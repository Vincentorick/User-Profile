package net.suncaper.userprofileTest.model

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions._

object AgeModel {
  def main(args: Array[String]): Unit = {
    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"age":{"cf":"cf", "col":"birthday", "type":"string"}
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

//    df.show(10, false)
    /** Convert data */
    val TsDf = df.withColumn("age-step", to_timestamp(col("age"), "yyyy-MM-dd"))
      .drop("age")

    val res = TsDf.select(
      'id,
      when(year($"age-step") >= 1950 and year($"age-step") < 1960, "50后")
        .when(year($"age-step") >= 1960 and year($"age-step") <= 1970, "60后")
        .when(year($"age-step") >= 1970 and year($"age-step") <= 1980, "70后")
        .when(year($"age-step") >= 1980 and year($"age-step") <= 1990, "80后")
        .when(year($"age-step") >= 1990 and year($"age-step") <= 2000, "90后")
        .when(year($"age-step") >= 2000 and year($"age-step") <= 2010, "00后")
        .when(year($"age-step") >= 2010 and year($"age-step") <= 2020, "10后")
        .when(year($"age-step") >= 2020 and year($"age-step") <= 2030, "20后")
        .otherwise("其他")
        .as("age-step")
    )
//    res.show(20,false)

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"renkoushuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"age-step":{"cf":"cf", "col":"age-step", "type":"string"}
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
