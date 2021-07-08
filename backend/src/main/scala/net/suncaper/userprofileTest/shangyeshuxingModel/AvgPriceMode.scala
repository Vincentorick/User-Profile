package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Using the aggregation functions to
 *  get the statics result.
 *
 */

object AvgPriceMode {

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
      .agg(avg('paidAmount) as "avgPrice")
      .select('memberId,
        when('avgPrice >= 1 and 'avgPrice <= 999, "1-999")
          .when('avgPrice >= 1000 and 'avgPrice <= 2999, "1000-2999")
          .when('avgPrice >= 3000 and 'avgPrice <= 4999, "3000-4999")
          .when('avgPrice >= 5000 and 'avgPrice <= 9999, "5000-9999")
          .otherwise("0")
          .as("avgPrice")
      )
      .withColumnRenamed("memberId", "id")


    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "avgPrice":{"cf":"cf", "col":"avgPrice", "type":"string"}
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
