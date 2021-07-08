package net.suncaper.userprofileTest

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Get a total Table
 *  using the `join` function.
 *
 */

object getTotalTable {

  def main(args: Array[String]): Unit = {

    def catalog_renKou =
      s"""{
         |"table":{"namespace":"default", "name":"renkoushuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"age-step":{"cf":"cf", "col":"age-step", "type":"string"},
         |"gender":{"cf":"cf", "col":"gender", "type":"string"},
         |"job":{"cf":"cf", "col":"job", "type":"string"},
         |"marriage":{"cf":"cf", "col":"marriage", "type":"string"},
         |"nationality":{"cf":"cf", "col":"nationality", "type":"string"},
         |"origin":{"cf":"cf", "col":"origin", "type":"string"},
         |"politicalFace":{"cf":"cf", "col":"politicalFace", "type":"string"},
         |"star":{"cf":"cf", "col":"star", "type":"string"}
         |}
         |}""".stripMargin

    def catalog_shangYe =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "avgPrice":{"cf":"cf", "col":"avgPrice", "type":"string"},
         |  "frequency":{"cf":"cf", "col":"frequency", "type":"string"},
         |  "buyFrequency":{"cf":"cf", "col":"buyFrequency", "type":"string"},
         |  "costForce_n":{"cf":"cf", "col":"costForce_n", "type":"string"},
         |  "customAsk":{"cf":"cf", "col":"customAsk", "type":"string"},
         |  "maxPerOrder":{"cf":"cf", "col":"maxPerOrder", "type":"string"},
         |  "paymentCode":{"cf":"cf", "col":"paymentCode", "type":"string"},
         |  "discount_n":{"cf":"cf", "col":"discount_n", "type":"string"}
         |}
         |}""".stripMargin

    def catalog_xingWei =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "browserTime":{"cf":"cf", "col":"browserTime", "type":"string"},
         |  "browsingPeriod":{"cf":"cf", "col":"browsingPeriod", "type":"string"},
         |  "logFrequency":{"cf":"cf", "col":"logFrequency", "type":"string"},
         |  "machineType":{"cf":"cf", "col":"machineType", "type":"string"},
         |  "recent":{"cf":"cf", "col":"recent", "type":"string"}
         |}
         |}""".stripMargin

    def catalog_email =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_users"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"email":{"cf":"cf", "col":"email", "type":"string"}
         |}
         |}""".stripMargin

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseAge")
      .getOrCreate()

    import spark.implicits._

    val df_renKou = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_renKou)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val df_shangYe = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_shangYe)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_shangYe = df_shangYe
      .withColumn("newId", col("id").substr(-3, 3))

    val res_shangYe_mid = res_shangYe.select('id, 'avgPrice, 'frequency, 'buyFrequency, 'costForce_n, 'customAsk,
    'maxPerOrder, 'paymentCode, 'discount_n,
      when('newId like("00_"), 'newId.substr(-1,1))
        .when('newId like("0__"), 'newId.substr(-2,2))
        .when('newId === "950",'newId )
        .when((('newId like("95_"))
          or ('newId like("96_"))
          or ('newId like("97_"))
          or ('newId like("98_"))
          or ('newId like("99_"))),"0" )
        .otherwise('newId)
        .as("newId")
    ).drop("id").withColumnRenamed("newId","id")
      .where('id =!= "0")

    val shangYe_link = res_shangYe_mid.dropDuplicates("id")

    val df_xingWei = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_xingWei)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val df_email = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog_email)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_mid = shangYe_link.join(df_email, shangYe_link.col("id") === df_email.col("id"))
      .select(shangYe_link.col("id"),
        shangYe_link.col("avgPrice"),
        df_email.col("email"),
        shangYe_link.col("frequency"),
        shangYe_link.col("buyFrequency"),
        shangYe_link.col("costForce_n"),
        shangYe_link.col("customAsk"),
        shangYe_link.col("maxPerOrder"),
        shangYe_link.col("paymentCode"),
        shangYe_link.col("discount_n")
      )

    val res_mid_renKou_shangYe = res_mid.join(df_renKou, Seq("id"), "left")

    val res_xingWei_renKou_shangYe = res_mid_renKou_shangYe.join(df_xingWei, Seq("id"), "left")

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"totalTable"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"email":{"cf":"cf", "col":"email", "type":"string"},
         |"avgPrice":{"cf":"cf", "col":"avgPrice", "type":"string"},
         |"frequency":{"cf":"cf", "col":"frequency", "type":"string"},
         |"buyFrequency":{"cf":"cf", "col":"buyFrequency", "type":"string"},
         |"costForce_n":{"cf":"cf", "col":"costForce_n", "type":"string"},
         |"customAsk":{"cf":"cf", "col":"customAsk", "type":"string"},
         |"maxPerOrder":{"cf":"cf", "col":"maxPerOrder", "type":"string"},
         |"paymentCode":{"cf":"cf", "col":"paymentCode", "type":"string"},
         |"discount_n":{"cf":"cf", "col":"discount_n", "type":"string"},
         |"age-step":{"cf":"cf", "col":"age-step", "type":"string"},
         |"gender":{"cf":"cf", "col":"gender", "type":"string"},
         |"job":{"cf":"cf", "col":"job", "type":"string"},
         |"marriage":{"cf":"cf", "col":"marriage", "type":"string"},
         |"nationality":{"cf":"cf", "col":"nationality", "type":"string"},
         |"origin":{"cf":"cf", "col":"origin", "type":"string"},
         |"politicalFace":{"cf":"cf", "col":"politicalFace", "type":"string"},
         |"star":{"cf":"cf", "col":"star", "type":"string"},
         |"browserTime":{"cf":"cf", "col":"browserTime", "type":"string"},
         |"browsingPeriod":{"cf":"cf", "col":"browsingPeriod", "type":"string"},
         |"logFrequency":{"cf":"cf", "col":"logFrequency", "type":"string"},
         |"machineType":{"cf":"cf", "col":"machineType", "type":"string"},
         |"recent":{"cf":"cf", "col":"recent", "type":"string"}
         |}
         |}""".stripMargin

    res_xingWei_renKou_shangYe.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }
}
