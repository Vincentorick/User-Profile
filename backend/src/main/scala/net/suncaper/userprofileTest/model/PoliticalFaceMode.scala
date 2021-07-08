package net.suncaper.userprofileTest.model

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions.when


object PoliticalFaceMode {

  def main(args: Array[String]): Unit = {

    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"politicalFace":{"cf":"cf", "col":"politicalFace", "type":"string"}
         |}
         |}""".stripMargin

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseJob")
      .getOrCreate()

    import spark.implicits._

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.select('id,
      when('politicalFace === "1", "群众")
        .when('politicalFace === "2", "党员")
        .when('politicalFace === "3", "无党派人士")
        .otherwise("其他")
        .as("politicalFace"))

  def catalogWrite =
    s"""{
       |"table":{"namespace":"default", "name":"renkoushuxing"},
       |"rowkey":"id",
       |"columns":{
       |"id":{"cf":"rowkey", "col":"id", "type":"string"},
       |"politicalFace":{"cf":"cf", "col":"politicalFace", "type":"string"}
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
