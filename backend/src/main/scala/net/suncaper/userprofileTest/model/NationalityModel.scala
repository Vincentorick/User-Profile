package net.suncaper.userprofileTest.model

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions.when


object NationalityModel {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseJob")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"nationality":{"cf":"cf", "col":"nationality", "type":"string"}
         |}
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.select('id,
      when('nationality === "1", "中国大陆")
        .when('nationality === "2", "中国香港")
        .when('nationality === "3", "中国澳门")
        .when('nationality === "4", "中国台湾")
        .when('nationality === "5", "其他")
        .otherwise("其他")
        .as("nationality"))

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"renkoushuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"nationality":{"cf":"cf", "col":"nationality", "type":"string"}
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
