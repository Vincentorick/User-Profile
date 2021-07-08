package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  About cycle or frequency:
 *  ('max - ' min) / 'count
 *
 */

object BuyCycleModel {

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
         |    "payTime":{"cf":"cf", "col":"payTime", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

//    df.show(20, false)

    val res = df.na.drop("any")
      .select('memberId, 'payTime)
      .where('payTime =!= 0)
      .groupBy('memberId)
      .agg(count('payTime) as "count", max('payTime) as "max", min('payTime) as "min")

    val writeRes = res.withColumn("frequency", ('max - 'min) / 'count)
      .select('memberId,
        when('frequency <= 604800, "7日")
          .when('frequency > 604800 and 'frequency <= 1209600, "2周")
          .when('frequency > 1209600 and 'frequency <= 2419200, "1月")
          .when('frequency > 2419200 and 'frequency <= 4838400, "2月")
          .when('frequency > 4838400 and 'frequency <= 7257600, "3月")
          .when('frequency > 7257600 and 'frequency <= 9676800, "4月")
          .when('frequency > 9676800 and 'frequency <= 12096000, "5月")
          .when('frequency > 12096000 and 'frequency <= 14515200, "6月")
          .otherwise("很久")
          .as("frequency"))
      .withColumnRenamed("memberId", "id")
      .drop("count", "max", "min")


    writeRes.show(20,false)
    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "frequency":{"cf":"cf", "col":"frequency", "type":"string"}
         |}
         |}""".stripMargin

    writeRes.write
      .option(HBaseTableCatalog.tableCatalog, catalogWrite)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()


    spark.stop()
  }
}
