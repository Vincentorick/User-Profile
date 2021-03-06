package net.suncaper.userprofileTest.yonghujiazhi

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.ml.recommendation.{ALS, ALSModel}
import org.apache.spark.ml.tuning.{CrossValidator, CrossValidatorModel, ParamGridBuilder}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DataTypes, LongType}


object ProductFavor {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("shc test")
      .master("local[10]")
      .getOrCreate()

    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_logs"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"},
         |"loc_url":{"cf":"cf", "col":"loc_url", "type":"string"}
         |}
         |}""".stripMargin

    import spark.implicits._

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val url2ProductId = udf(getProductId _)
    val predict2StringFunc  = udf(predict2String _)
    val ratingDF = df.select(col("global_user_id").as("userId").cast(DataTypes.IntegerType),
      url2ProductId('loc_url).as("productId").cast(DataTypes.IntegerType)).filter('productId.isNotNull)
      .groupBy('userId,'productId)
      .agg(count('productId).as("rating"))

    /** 80% train set, 20% test set */
    val Array(trainSet, testSet) = ratingDF.randomSplit(Array(0.8, 0.2))

    // Evaluator for model
    val evaluator: RegressionEvaluator = new RegressionEvaluator()
      .setLabelCol("rating")
      .setPredictionCol("predict")
      .setMetricName("rMSE")

    val als = new ALS()
      .setUserCol("userId")
      .setItemCol("productId")
      .setRatingCol("rating")
      .setPredictionCol("predict")
      .setColdStartStrategy("drop")
      .setAlpha(10)
      .setMaxIter(5)
      .setRank(5)
      .setRegParam(0.01)
      .setImplicitPrefs(true)


    val model = ALSModel.load("model/product/als")

    val result:DataFrame = model.recommendForAllUsers(10)
      .withColumn("favorProducts", predict2StringFunc('recommendations))
      .withColumnRenamed("userId", "id")
      .drop('recommendations)
      .select('id.cast(LongType), 'favorProducts)

    result.show(100,false)

        def recommendationCatalog =
          s"""{
             |  "table":{"namespace":"default", "name":"user_recom"},
             |  "rowkey":"id",
             |   "columns":{
             |     "id":{"cf":"rowkey", "col":"id", "type":"Long"},
             |     "favorProducts":{"cf":"cf", "col":"favorProducts", "type":"string"}
             |   }
             |}""".stripMargin

        result.write
          .option(HBaseTableCatalog.tableCatalog, recommendationCatalog)
          .option(HBaseTableCatalog.newTable, "5")
          .format("org.apache.spark.sql.execution.datasources.hbase")
          .save()

        // ??????als pipeline
        val pipeline: Pipeline = new Pipeline().setStages(Array(als))

        // ??????????????????
        val paramGrid: Array[ParamMap] = new ParamGridBuilder()
          .addGrid(als.rank, Array[Int](5, 8, 10, 14, 17))
          .addGrid(als.maxIter, Array[Int](5, 7, 10, 13))
          .addGrid(als.regParam, Array[Double](0.01, 0.05, 0.1, 0.3, 0.5, 0.8))
          .build

        // ????????????????????????????????????
        val crossValidator: CrossValidator = new CrossValidator()
          .setEstimator(pipeline) // pipeline??????
          .setEvaluator(evaluator) // ?????????
          .setEstimatorParamMaps(paramGrid) // ????????????
          .setNumFolds(2) // ???????????????3+??????

        // ??????????????????????????????????????????????????????
        val crossValidatorModel: CrossValidatorModel = crossValidator.fit(trainSet)

        // ?????????????????????????????????
        val avgMetrics: Array[Double] = crossValidatorModel.avgMetrics

        // ???????????????????????????
        val estimatorParamMaps: Array[ParamMap] = crossValidatorModel.getEstimatorParamMaps
        for (i <- 1 to estimatorParamMaps.length - 1) {
          println(s"------ ???${i}??????????????????Metric???${avgMetrics(i)} -------")
          val paramMap: ParamMap = estimatorParamMaps(i)
          paramMap.toSeq.foreach(p => {
            println(s"----- ???${i}??????????????????????????????????????????????????????${p.param.name} -> ${p.value}")
          })
        }


        // ???????????????
        val bestPipeline: Pipeline = crossValidatorModel.bestModel.parent.asInstanceOf[Pipeline]
        val stage = bestPipeline.getStages(0)
        val paramMap: ParamMap = stage.extractParamMap
        val rank: Any = paramMap.get(stage.getParam("rank")).get
        val maxIter: Any = paramMap.get(stage.getParam("maxIter")).get
        val regParam: Any = paramMap.get(stage.getParam("regParam")).get
        println("==== paras for ALS???rank={},maxIter={},regParam={} ====", rank, maxIter, regParam)

        // ???????????????
        val testPredicts: Dataset[Row] = crossValidatorModel.transform(testSet)
        // ???????????????
        val testRmse: Double = evaluator.evaluate(testPredicts)
        // ???????????????
        val trainPredicts: Dataset[Row] = crossValidatorModel.transform(trainSet)
        // ???????????????
        val trainRmse: Double = evaluator.evaluate(trainPredicts)
        println("==== ????????????????????????RMSE????????????????????????RMSE={},?????????RMSE={} ====", trainRmse, testRmse)


    spark.stop()
  }

  def getProductId(url: String) = {
    var productId: String = null
    if (url.contains("/product/") && url.contains(".html")) {
      val start: Int = url.indexOf("/product/")
      val end: Int = url.indexOf(".html")
      if (end > start) {
        productId = url.substring(start + 9, end)
      }
    }
    productId
  }

  def predict2String(arr: Seq[Row]) = {
    arr.map(_.getAs[Int]("productId")).mkString(",")
  }


}
