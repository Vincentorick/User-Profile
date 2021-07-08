package net.suncaper.userprofileTest.model

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions.{col, month, substring, to_date, to_timestamp, when, year, dayofyear}

/**
 *
 *  Get DayOfYear by using the sql function:
 *  `dayofyear`, then compare the day to the
 *  boundary of those Constellation.
 *
 */

object StarModel {

  def main(args: Array[String]): Unit = {

    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"birthday":{"cf":"cf", "col":"birthday", "type":"string"}
         |}
         |}""".stripMargin

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseAge")
      .getOrCreate()

    import spark.implicits._

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val TsDf = df.withColumn("star", to_timestamp(col("birthday"), "yyyy-MM-dd"))
      .drop("birthday")

    val res = TsDf.select(
      'id,
      when(dayofyear($"star") >= 80 and dayofyear($"star") <= 110, "白羊座")
        .when(dayofyear($"star") >= 111 and dayofyear($"star") <= 140, "金牛座")
        .when(dayofyear($"star") >= 141 and dayofyear($"star") <= 172, "双子座")
        .when(dayofyear($"star") >= 173 and dayofyear($"star") <= 203, "巨蟹座")
        .when(dayofyear($"star") >= 204 and dayofyear($"star") <= 234, "狮子座")
        .when(dayofyear($"star") >= 235 and dayofyear($"star") <= 267, "处女座")
        .when(dayofyear($"star") >= 268 and dayofyear($"star") <= 296, "天秤座")
        .when(dayofyear($"star") >= 297 and dayofyear($"star") <= 326, "天蝎座")
        .when(dayofyear($"star") >= 327 and dayofyear($"star") <= 355, "射手座")
        .when(dayofyear($"star") >= 356 or dayofyear($"star") <= 20, "摩羯座")
        .when(dayofyear($"star") >= 21 and dayofyear($"star") <= 50, "水瓶座")
        .when(dayofyear($"star") >= 51 and dayofyear($"star") <= 140, "双鱼座")
        .otherwise("其他")
        .as("star")
    )

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"renkoushuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"star":{"cf":"cf", "col":"star", "type":"string"}
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
