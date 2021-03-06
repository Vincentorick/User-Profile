package net.suncaper.userprofileTest.yonghujiazhi

import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.sql.{Column, DataFrame, SparkSession, functions}
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.functions._


object RFMModel {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_orders"},
         |  "rowkey":"id",
         |  "columns":{
         |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |    "memberId":{"cf":"cf", "col":"memberId", "type":"string"},
         |    "orderSn":{"cf":"cf", "col":"orderSn", "type":"string"},
         |    "orderAmount":{"cf":"cf", "col":"orderAmount", "type":"string"},
         |    "finishTime":{"cf":"cf", "col":"finishTime", "type":"string"}
         |  }
         |}""".stripMargin

    val spark = SparkSession.builder()
      .appName("shc test")
      .master("local[10]")
      .getOrCreate()

    import spark.implicits._

    val source: DataFrame = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val colRencency = "rencency"
    val colFrequency = "frequency"
    val colMoneyTotal = "moneyTotal"
    val colFeature = "feature"
    val colPredict = "predict"
    val days_range = 660

    // 统计距离最近一次消费的时间
    val recencyCol = datediff(date_sub(current_timestamp(), days_range), from_unixtime(max('finishTime))) as colRencency
    // 统计订单总数
    val frequencyCol = count('orderSn) as colFrequency
    // 统计订单总金额
    val moneyTotalCol = sum('orderAmount) as colMoneyTotal

    val RFMResult = source.groupBy('memberId)
      .agg(recencyCol, frequencyCol, moneyTotalCol)

    // 2.为RFM打分
    // R: 1-3天=5分，4-6天=4分，7-9天=3分，10-15天=2分，大于16天=1分
    // F: ≥200=5分，150-199=4分，100-149=3分，50-99=2分，1-49=1分
    // M: ≥20w=5分，10-19w=4分，5-9w=3分，1-4w=2分，<1w=1分
    val recencyScore: Column = functions.when((col(colRencency) >= 1) && (col(colRencency) <= 3), 5)
      .when((col(colRencency) >= 4) && (col(colRencency) <= 6), 4)
      .when((col(colRencency) >= 7) && (col(colRencency) <= 9), 3)
      .when((col(colRencency) >= 10) && (col(colRencency) <= 15), 2)
      .when(col(colRencency) >= 16, 1)
      .as(colRencency)

    val frequencyScore: Column = functions.when(col(colFrequency) >= 200, 5)
      .when((col(colFrequency) >= 150) && (col(colFrequency) <= 199), 4)
      .when((col(colFrequency) >= 100) && (col(colFrequency) <= 149), 3)
      .when((col(colFrequency) >= 50) && (col(colFrequency) <= 99), 2)
      .when((col(colFrequency) >= 1) && (col(colFrequency) <= 49), 1)
      .as(colFrequency)

    val moneyTotalScore: Column = functions.when(col(colMoneyTotal) >= 200000, 5)
      .when(col(colMoneyTotal).between(100000, 199999), 4)
      .when(col(colMoneyTotal).between(50000, 99999), 3)
      .when(col(colMoneyTotal).between(10000, 49999), 2)
      .when(col(colMoneyTotal) <= 9999, 1)
      .as(colMoneyTotal)

    val RFMScoreResult = RFMResult.select('memberId, recencyScore, frequencyScore, moneyTotalScore)

    val vectorDF = new VectorAssembler()
      .setInputCols(Array(colRencency, colFrequency, colMoneyTotal))
      .setOutputCol(colFeature)
      .transform(RFMScoreResult)

    val kmeans = new KMeans()
      .setK(7)
      .setSeed(100)
      .setMaxIter(2)
      .setFeaturesCol(colFeature)
      .setPredictionCol(colPredict)

    // train model
    val model = kmeans.fit(vectorDF)

    val predicted = model.transform(vectorDF)

    val res = predicted
      .drop("id")
      .withColumnRenamed("memberId", "id")
      .withColumn("newId", col("id").substr(-3, 3))

    val res_mid = res.select('id, 'predict,
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
    )

    val res_write = res_mid.drop("id").withColumnRenamed("newId","id")
      .where('id =!= "0").select('id, 'predict)

    val res_write_total = res_write.select('id,
      when('predict === 1, "超高")
    .when('predict === 2, "高")
        .when('predict === 3, "中上")
        .when('predict === 4, "中")
        .when('predict === 5, "中下")
        .when('predict === 6, "低")
        .when('predict === 0, "很低")
    .as("costForce_n"))

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"totalTable"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"costForce_n":{"cf":"cf", "col":"costForce_n", "type":"string"}
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
