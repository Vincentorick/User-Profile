package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object MaxPerOrder {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseAge")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_orders"},
         |  "rowkey":"id",
         |  "columns":{
         |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |    "memberId":{"cf":"cf", "col":"memberId", "type":"string"},
         |    "paidAmount":{"cf":"cf", "col":"paidAmount", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.groupBy('memberId)
      .agg(max('paidAmount) as "maxPerOrder")
      .select('memberId,
        when('maxPerOrder >= 1 and 'maxPerOrder <= 999, "1-999")
          .when('maxPerOrder >= 1000 and 'maxPerOrder <= 2999, "1000-2999")
          .when('maxPerOrder >= 3000 and 'maxPerOrder <= 4999, "3000-4999")
          .when('maxPerOrder >= 5000 and 'maxPerOrder <= 9999, "5000-9999")
          .otherwise("0")
          .as("maxPerOrder")
      )
      .withColumnRenamed("memberId", "id")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "maxPerOrder":{"cf":"cf", "col":"maxPerOrder", "type":"string"}
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
