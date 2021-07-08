package net.suncaper.userprofileTest.userInterface

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object findUserByEmail {
//  def main(args: Array[String]): Unit = {
//
//    val test = findByEmail("wcfr817e@yeah.net")
//
//    println(test.)
//
//  }

  def findByEmail(email:String) = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseTest")
      .getOrCreate()

    import spark.implicits._

    def catalog =
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

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df.where(col("email") === email)

//    spark.stop()
    res.collectAsList()

  }
}
