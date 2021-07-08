package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object BuyFrequencyModel {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseAge")
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

    val res = df.na.drop("any")
      .select('memberId, 'payTime)
      .where('payTime =!= 0)
      .groupBy('memberId)
      .agg(count('payTime) as "count", max('payTime) as "max", min('payTime) as "min")
      .withColumn("t_frequency", ('max - 'min) / 'count)
      .withColumn("row_num", row_number() over Window.orderBy('t_frequency.desc))
      .withColumn("buyFrequency", 'row_num / 969)
      .select('memberId,
        when('buyFrequency <= 0.2, "高")
          .when('buyFrequency > 0.2 and 'buyFrequency <= 0.8, "中")
          .when('buyFrequency > 0.8 , "低")
          .as("buyFrequency")
      ).withColumnRenamed("memberId", "id")
      .drop("count", "row_num",  "max", "min", "t_frequency")

//    res.show(20,false)

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"shangyeshuxing"},
         |"rowkey":"id",
         |"columns":{
         |  "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |  "buyFrequency":{"cf":"cf", "col":"buyFrequency", "type":"string"}
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
