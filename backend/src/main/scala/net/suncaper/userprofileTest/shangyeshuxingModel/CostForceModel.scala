package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  In the beginning,
 *  we use rank of payment to
 *  decide the ability of consumer.
 *
 */

object CostForceModel {

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
      .agg(sum('paidAmount) as "costAmount")
      .withColumn("row_num", row_number() over Window.orderBy('costAmount.desc))

    /** 969 */

    val res_write = res.withColumn("costForce_n", 'row_num / 969)
      .select('memberId,
        when('costForce_n <= 0.05, "超高")
          .when('costForce_n > 0.05 and 'costForce_n <= 0.1, "高")
          .when('costForce_n > 0.1 and 'costForce_n <= 0.2, "中上")
          .when('costForce_n > 0.2 and 'costForce_n <= 0.5, "中")
          .when('costForce_n > 0.5 and 'costForce_n <= 0.8, "中下")
          .when('costForce_n > 0.8 and 'costForce_n <= 0.9, "低")
          .when('costForce_n > 0.9 and 'costForce_n <= 0.95, "很低")
          .as("costForce_n")
      ).withColumnRenamed("memberId", "id")
      .drop("costAmount", "row_num")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "costForce_n":{"cf":"cf", "col":"costForce_n", "type":"string"}
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
