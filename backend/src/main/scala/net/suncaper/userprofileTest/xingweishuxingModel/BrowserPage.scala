package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object BrowserPage {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HBase")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_logs"},
         |  "rowkey":"id",
         |  "columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "loc_url":{"cf":"cf", "col":"loc_url", "type":"string"},
         |  "global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"}
         |}
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_mid = df.select('global_user_id, when('loc_url like  "%itemlist%" , "商品页")
      .when('loc_url like  "%index%", "首页")
      .when('loc_url like  "%login%", "登录页")
      .when('loc_url like  "%subject%", "分类页")
      .when('loc_url like  "%myCart%", "我的订单页")
      .otherwise("未知").as("browsingPage"))
      .withColumnRenamed("global_user_id", "id")

    val res = res_mid.where('browsingPage =!= "未知")
      .groupBy('id, 'browsingPage)
      .agg(count('browsingPage) as "count")
      .withColumn("row_num", row_number() over Window.partitionBy('browsingPage).orderBy('count.desc))
      .where('row_num === 1)
     .drop("count", "row_num")

    res.show(20,false)

    spark.stop()
  }
}
