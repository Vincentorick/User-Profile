package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object GoodsLikeModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseAge")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_goods"},
         |  "rowkey":"id",
         |  "columns":{
         |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |    "productType":{"cf":"cf", "col":"productType", "type":"string"},
         |    "productId":{"cf":"cf", "col":"productId", "type":"string"},
         |    "productName":{"cf":"cf", "col":"productName", "type":"string"},
         |    "brandId":{"cf":"cf", "col":"brandId", "type":"string"},
         |    "orderId":{"cf":"cf", "col":"orderId", "type":"string"}
         |  }
         |}""".stripMargin

    val df_goods = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val df_goods_name = df_goods.select(col("id"), col("productName"))
      .groupBy(col("productName"))
      .agg(count(col("productName") as "count")
        .as("count"))

    val res_goods_name = df_goods_name.select('count,
            when(instr($"productName","海尔")=!=0, "海尔")
          .when(instr($"productName","卡萨帝")=!=0, "卡萨帝")
          .when(instr($"productName","摩卡")=!=0, "摩卡")
          .when(instr($"productName","小超人")=!=0 , "小超人")
          .when(instr($"productName","统帅")=!=0, "统帅")
              .as("productName")
          )

    res_goods_name.groupBy('productName).agg(sum('count)).show(100, false)

    spark.stop()
  }
}
