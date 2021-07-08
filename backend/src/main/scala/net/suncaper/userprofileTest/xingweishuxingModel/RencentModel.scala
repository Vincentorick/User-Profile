package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.{col, to_timestamp,from_unixtime}


object RencentModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("HBase")
      .master("local")
      .getOrCreate()


    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"recentlogin":{"cf":"cf", "col":"lastLoginTime", "type":"string"}
         |}
         |}""".stripMargin

    import spark.implicits._

    var df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    df = df.withColumn("pt_d", from_unixtime(col("recentlogin"), "yyyy-MM-dd"))

    /** max => 1445312238 */

    var df_after = df.select(df.col("id"),df.col("recentlogin").cast("int").as("recentInt"))

    df_after = df_after.withColumn("Recentloginweek",expr("(1445312238-recentInt)/86400"))

    val result = df_after.select('id,when('Recentloginweek <= 1,"一天之内")
      .when('Recentloginweek >1 and 'Recentloginweek <= 7,"一周之内")
      .when('Recentloginweek >7 and 'Recentloginweek <= 14,"二周之内")
      .when('Recentloginweek >14 and 'Recentloginweek <= 30,"一个月之内")
      .otherwise("一个月以上").as("recent"))

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"recent":{"cf":"cf", "col":"recent", "type":"string"}
         |}
         |}""".stripMargin


    result.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()


    spark.stop()
  }
}
