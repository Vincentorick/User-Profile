package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Use spark's function
 *  unix_timestamp
 *  to convert the datatype,
 *  and then compare with rank.
 *
 */

object LogFrequencyModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("HBase")
      .master("local")
      .getOrCreate()

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_logs"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"},
         |  "log_time":{"cf":"cf", "col":"log_time", "type":"string"}
         |  }
         |}""".stripMargin

    import spark.implicits._

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val df_mid = df.select("global_user_id","log_time")
      .withColumnRenamed("global_user_id", "id")

    val res_mid = df_mid.na.drop("any")
      .select('id, 'log_time)
      .withColumn("log_timestamp", unix_timestamp(col("log_time")))
      .drop("log_time")

      val res_mid_a = res_mid
      .groupBy('id)
      .agg(count('log_timestamp) as "count", max('log_timestamp) as "max", min('log_timestamp) as "min")
      .withColumn("t_frequency", ('max - 'min) / 'count)
      .withColumn("row_num", row_number() over Window.orderBy('t_frequency.desc))
      .withColumn("buyFrequency", 'row_num / 969)

    val res_mid_b = res_mid_a
      .select('id,
        when('buyFrequency <= 0.2, "经常")
          .when('buyFrequency > 0.2 and 'buyFrequency <= 0.5, "偶尔")
          .when('buyFrequency > 0.8 and 'buyFrequency <= 0.9, "很少")
          .when('buyFrequency > 0.9, "从不")
          .as("logFrequency")
      )
      .drop("count", "row_num",  "max", "min", "t_frequency")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "logFrequency":{"cf":"cf", "col":"logFrequency", "type":"string"}
         |}
         |}""".stripMargin

    res_mid_b.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }
}
