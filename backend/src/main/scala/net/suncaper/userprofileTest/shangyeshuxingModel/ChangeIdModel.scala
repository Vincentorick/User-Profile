package net.suncaper.userprofileTest.shangyeshuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  For connection of 'memberId and 'global_user_id
 *  use the Regular expressions of SQL.
 *
 */

object ChangeIdModel {

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
         |    "memberId":{"cf":"cf", "col":"memberId", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res = df
      .drop("id")
      .withColumnRenamed("memberId", "id")
      .withColumn("newId", col("id").substr(-3, 3))

    val res_mid = res.select('id,
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
      .where('id =!= "0").select('id)

    val res_change = res_write.groupBy('id).agg(count('id)).select('id)

    res_change.show(20,false)

    spark.stop()
  }
}
