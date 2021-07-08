package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Use the spark function:
 *  Window
 *  to get the most used way of payment.
 *
 */

object PaymentWayModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("HbaseTest")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_orders"},
         |  "rowkey":"id",
         |  "columns":{
         |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |    "memberId":{"cf":"cf", "col":"memberId", "type":"string"},
         |    "paymentCode":{"cf":"cf", "col":"paymentCode", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.groupBy('memberId, 'paymentCode)
      .agg(count('paymentCode) as "count")
      .withColumn("row_num", row_number() over Window.partitionBy('memberId).orderBy('count.desc))
      .where('row_num === 1)
      .withColumnRenamed("memberId", "id").drop("count", "row_num")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "paymentCode":{"cf":"cf", "col":"paymentCode", "type":"string"}
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
