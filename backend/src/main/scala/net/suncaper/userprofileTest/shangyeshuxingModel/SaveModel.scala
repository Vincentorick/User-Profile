package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object SaveModel {

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
         |    "paidAmount":{"cf":"cf", "col":"paidAmount", "type":"string"},
         |    "productAmount":{"cf":"cf", "col":"productAmount", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.na.drop("any")
      .select('memberId, 'paidAmount, 'productAmount)
      .where('paidAmount =!= 0)
      .withColumn("discount", 'paidAmount / 'productAmount)

    val discountRes = res
      .groupBy('memberId)
      .agg(min(col("discount")) as "min").as("min")
      .select('memberId,
      when('min <= 0.5, "3折-4折")
        .when('min > 0.5 and 'min <= 0.8, "5折-7折")
        .when('min > 0.8, "8折-9折")
        .as("discount_n")
    )
      .withColumnRenamed("memberId", "id")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "discount_n":{"cf":"cf", "col":"discount_n", "type":"string"}
         |}
         |}""".stripMargin

    discountRes.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }
}
