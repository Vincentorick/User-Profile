package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object CustomAskModel {

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
         |    "smManualTime":{"cf":"cf", "col":"smManualTime", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_total = df.groupBy('memberId)
      .agg(count('smManualTime) as "count")
      .withColumnRenamed("memberId", "id")

    val res_part = df.select('memberId, 'smManualTime)
      .where('smManualTime =!= 0)
      .groupBy('memberId)
      .agg(count('smManualTime) as "count_t")
      .withColumnRenamed("memberId", "id")

    val res = res_total.join(res_part, res_total.col("id") === res_part.col("id"))
      .select(res_total.col("id"),
        res_part.col("count_t"),
        res_total.col("count"))
      .withColumn("customAsk_t", 'count_t / 'count)
      .drop("count_t", "count")

    val res_write = res.select('id,
      when('customAsk_t < 0.1, "低")
    .when('customAsk_t >= 0.1 and 'customAsk_t <= 0.15, "中")
    .when('customAsk_t > 0.15, "高").as("customAsk"))

    res_write.show(20,false)

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "customAsk":{"cf":"cf", "col":"customAsk", "type":"String"}
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
