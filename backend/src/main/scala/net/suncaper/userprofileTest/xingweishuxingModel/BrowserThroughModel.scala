package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Use spark's function
 *  lag
 *  to make operation between current record and last record.
 *
 */

object BrowserThroughModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("HbaseTest")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_logs"},
         |  "rowkey":"id",
         |  "columns":{
         |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |    "global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"},
         |    "log_time":{"cf":"cf", "col":"log_time", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val TsDf = df.withColumn("log_date", unix_timestamp(col("log_time"), "yyyy-MM-dd HH:mm:ss"))
      .drop("log_time")

    val res = TsDf.select($"global_user_id",$"log_date", ($"log_date"-lag($"log_date", 1, null)
      .over(Window.partitionBy("global_user_id").orderBy("log_date"))).as("log_diff"))

    val res_mid = res
      .na.drop("any")
      .where('log_diff <= 1800)
      .select('global_user_id,
        when('log_diff <= 60, "1分钟内")
          .when('log_diff > 60 and 'log_diff <= 300, "1-5分钟")
          .when('log_diff > 300 and 'log_diff <= 1800, "5分钟以上")
      .as("browserTime")
      )
      .withColumnRenamed("global_user_id", "id")

    val res_write = res_mid.groupBy('id, 'browserTime)
      .agg(count('browserTime) as "count")
      .withColumn("row_num", row_number() over Window.partitionBy('id).orderBy('count.desc))
      .where('row_num === 1)
      .drop("count", "row_num")

    res_write.show(20,false)

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "browserTime":{"cf":"cf", "col":"browserTime", "type":"string"}
         |}
         |}""".stripMargin

    res_write.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }
}
