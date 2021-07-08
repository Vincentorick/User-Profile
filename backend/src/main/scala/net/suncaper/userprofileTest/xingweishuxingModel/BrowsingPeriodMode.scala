package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Use spark's function
 *  hour
 *  to get the hour in log_time.
 *
 */

object BrowsingPeriodMode {

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

    val res_mid = df.withColumn("hour", hour(col("log_time")))

    val res = res_mid.select('global_user_id, when('hour>=1 and 'hour <=7 ,"1点-7点")
      .when('hour >=8 and 'hour <=12 ,"8点-12点")
      .when('hour >=13 and 'hour <=17 ,"13点-17点")
      .when('hour >=18 and 'hour <=21 ,"18点-21点")
      .when(('hour >=22 and 'hour <=23) or 'hour < 1 ,"22点-24点")
      .otherwise("未知").as("browsingPeriod"))
      .withColumnRenamed("global_user_id", "id")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "browsingPeriod":{"cf":"cf", "col":"browsingPeriod", "type":"string"}
         |}
         |}""".stripMargin

    res.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }
}
