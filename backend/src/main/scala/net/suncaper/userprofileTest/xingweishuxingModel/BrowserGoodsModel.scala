package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DataTypes

/**
 *
 *  Matching url
 *  by spark's function,
 *  like crawler.
 *
 */

object BrowserGoodsModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("HbaseTest")
      .master("local")
      .getOrCreate()

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_logs"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"},
         |  "loc_url":{"cf":"cf", "col":"loc_url", "type":"string"}
         |}
         |}""".stripMargin

    import spark.implicits._

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()


    val url_ProductId = udf(getProductId _)

    val res_mid = df.select(col("global_user_id").as("id"),
      url_ProductId('loc_url).as("productId").cast(DataTypes.IntegerType))
      .filter('productId.isNotNull).orderBy("id")

    def catalog_link =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_goods"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"},
         |  "productId":{"cf":"cf", "col":"productId", "type":"string"},
         |  "productType":{"cf":"cf", "col":"productType", "type":"string"},
         |  "productName":{"cf":"cf", "col":"productName", "type":"string"}
         |}
         |}""".stripMargin

    val df_link = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_link)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_link = df_link.join(res_mid, df_link.col("productId") === res_mid.col("productId"))
      .select(res_mid.col("id"),
        res_mid.col("productId"),
        df_link.col("productType"),
        df_link.col("productName"))

    val res = res_link
      .where('productType =!= "其他")
      .groupBy('id, 'productType)
      .agg(count('productType) as "count")
      .withColumn("row_num", row_number() over Window.partitionBy('id).orderBy('count.desc))
      .where('row_num === 1)
      .drop("count", "row_num")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "productType":{"cf":"cf", "col":"productType", "type":"string"}
         |}
         |}""".stripMargin

    res.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }

  def getProductId(url: String) = {

    var productId: String = null
    if (url.contains("/product/") && url.contains(".html")) {
      val start: Int = url.indexOf("/product/")
      val end: Int = url.indexOf(".html")
      if (end > start) {
        productId = url.substring(start + 9, end)
      }
    }
    productId
  }
}
