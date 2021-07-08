package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object GoodLikeType {

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

    df_goods.show(20,false)


    val df_goods_mid = df_goods.select(col("id"), col("productType"))
      .groupBy(col("productType"))
      .agg(count(col("productType") as "count").as("count"))

    df_goods_mid.show()

    val res_goods_type = df_goods_mid.select('count,
      when(instr($"productType","冰")=!=0, "冰箱")
        .when(instr($"productType","冷")=!=0, "冷柜")
        .when(instr($"productType","电视")=!=0, "彩电")
        .when(instr($"productType","灶")=!=0 or instr($"productType","烤")=!=0
          or instr($"productType","饭")=!=0 or instr($"productType","炉")=!=0, "厨房电器")
        .when(instr($"productType","热水")=!=0 or instr($"productType","电水")=!=0, "热水器")
        .when(instr($"productType","挂烫机")=!=0 or instr($"productType","嵌入式厨电")=!=0
              or instr($"productType","吸尘器")=!=0 or instr($"productType","前置过滤器")=!=0,
              "生活小电")
        .when(instr($"productType","衣")=!=0, "洗衣机")
        .when(instr($"productType","净水机")=!=0 or instr($"productType","空气净化器")=!=0, "水家电")
        .when(instr($"productType","取暖电器")=!=0, "空调").as("productType")
        )

        res_goods_type.groupBy('productType).agg(sum('count)).show(100, false)

    spark.stop()
  }
}
