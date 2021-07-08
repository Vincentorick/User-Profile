package net.suncaper.userprofileTest

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Use foreach to show
 *  the result of static.
 *
 */

object GetResult {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("HBase")
      .master("local")
      .getOrCreate()

    def catalog_renKou =
      s"""{
         |  "table":{"namespace":"default", "name":"renkoushuxing"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "age-step":{"cf":"cf", "col":"age-step", "type":"string"},
         |  "gender":{"cf":"cf", "col":"gender", "type":"string"},
         |  "job":{"cf":"cf", "col":"job", "type":"string"},
         |  "marriage":{"cf":"cf", "col":"marriage", "type":"string"},
         |  "nationality":{"cf":"cf", "col":"nationality", "type":"string"},
         |  "origin":{"cf":"cf", "col":"origin", "type":"string"},
         |  "politicalFace":{"cf":"cf", "col":"politicalFace", "type":"string"},
         |  "star":{"cf":"cf", "col":"star", "type":"string"}
         |}
         |}""".stripMargin

    def catalog_shangYe =
      s"""{
         |  "table":{"namespace":"default", "name":"shangyeshuxing"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "avgPrice":{"cf":"cf", "col":"avgPrice", "type":"string"},
         |  "frequency":{"cf":"cf", "col":"frequency", "type":"string"},
         |  "buyFrequency":{"cf":"cf", "col":"buyFrequency", "type":"string"},
         |  "costForce_n":{"cf":"cf", "col":"costForce_n", "type":"string"},
         |  "customAsk":{"cf":"cf", "col":"customAsk", "type":"string"},
         |  "maxPerOrder":{"cf":"cf", "col":"maxPerOrder", "type":"string"},
         |  "paymentCode":{"cf":"cf", "col":"paymentCode", "type":"string"},
         |  "discount":{"cf":"cf", "col":"discount", "type":"string"}
         |}
         |}""".stripMargin

    def catalog_xingWei =
      s"""{
         |  "table":{"namespace":"default", "name":"xingweishuxing"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "productType":{"cf":"cf", "col":"productType", "type":"string"},
         |  "browserTime":{"cf":"cf", "col":"browserTime", "type":"string"},
         |  "browsingPeriod":{"cf":"cf", "col":"browsingPeriod", "type":"string"},
         |  "machineType":{"cf":"cf", "col":"machineType", "type":"string"},
         |  "recent":{"cf":"cf", "col":"recent", "type":"string"},
         |  "visitFrequency":{"cf":"cf", "col":"visitFrequency", "type":"string"}
         |}
         |}""".stripMargin

    import spark.implicits._

    val df_renKou = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_renKou)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val df_shangYe = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_shangYe)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val df_xingWei = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_xingWei)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val param_renKou = Array("age-step", "gender", "job", "marriage", "nationality", "origin", "politicalFace", "star")
    val param_shangYe = Array("avgPrice", "frequency", "buyFrequency", "costForce", "customAsk", "maxPerOrder", "paymentCode", "discount")
    val param_xingWei = Array("productType", "browserTime", "browsingPeriod", "machineType", "recent", "visitFrequency")

    param_renKou.foreach ((field:String) =>
      df_renKou.select(col("id"), col(field))
        .groupBy(col(field))
        .agg(count(col(field) as "count"))
        .show()
    )

    param_shangYe.foreach ((field:String) =>
            df_shangYe.select(col("id"), col(field))
              .groupBy(col(field))
              .agg(count(col(field) as "count"))
              .show()
    )

    param_xingWei.foreach ((field:String) =>
      df_xingWei.select(col("id"), col(field))
        .groupBy(col(field))
        .agg(count(col(field) as "count"))
        .show()
    )

    spark.stop()
  }
}
