package net.suncaper.userprofileTest

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog


object HBaseTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseTest")
      .getOrCreate()

    def catalog = s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"user_agent":{"cf":"cf", "col":"username", "type":"string"}
         |}
         |}""".stripMargin

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_logs_test_1"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"user_agent":{"cf":"cf", "col":"user_agent", "type":"string"}
         |}
         |}""".stripMargin

    val df = spark.read.option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    df.show(20, false)

    /*
    df.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

     */


    spark.stop()
  }
}
