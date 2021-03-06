package net.suncaper.userprofileTest.model

import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession}


object JobModel {

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
         |"job":{"cf":"cf", "col":"job", "type":"string"}
         |}
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.select('id,
      when('job === "1", "学生")
      .when('job === "2", "公务员")
      .when('job === "3", "军人")
      .when('job === "4", "警察")
      .when('job === "5", "教师")
      .when('job === "6", "白领")
      .otherwise("其他")
      .as("job"))

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"renkoushuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"job":{"cf":"cf", "col":"job", "type":"string"}
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
