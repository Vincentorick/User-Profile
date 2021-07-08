package net.suncaper.userprofileTest

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object AddColumnBackFrequency {

  def main(args: Array[String]): Unit = {

    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"tbl_orders"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"memberId":{"cf":"cf", "col":"memberId", "type":"string"},
         |"orderStatus":{"cf":"cf", "col":"orderStatus", "type":"string"}
         |}
         |}""".stripMargin

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseTest")
      .getOrCreate()

    import spark.implicits._

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_total = df.groupBy('memberId)
      .agg(count('orderStatus) as "count")

    val res_back = df.where('orderStatus === 0)
      .groupBy('memberId)
      .agg(count('orderStatus) as "count_back")

    val res_change = df.where('orderStatus === 1)
      .groupBy('memberId)
      .agg(count('orderStatus) as "count_change")

    /** total */
    val res_t = res_total
      .withColumnRenamed("memberId", "id")
      .withColumn("newId", col("id").substr(-3, 3))

    val res_mid_total = res_t.select('id, 'count,
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
    val res_write_total = res_mid_total.drop("id")
      .withColumnRenamed("newId","id")
      .dropDuplicates("id")
      .where('id =!= "0").select('id, 'count)

    /** back */
    val res_b = res_back
      .withColumnRenamed("memberId", "id")
      .withColumn("newId", col("id").substr(-3, 3))

    val res_mid_back = res_b.select('id, 'count_back,
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
    val res_write_back = res_mid_back.drop("id")
      .withColumnRenamed("newId","id")
      .dropDuplicates("id")
      .where('id =!= "0").select('id, 'count_back)

    /** change */
    val res_c = res_change
      .withColumnRenamed("memberId", "id")
      .withColumn("newId", col("id").substr(-3, 3))

    val res_mid_change = res_c.select('id, 'count_change,
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

    val res_write_change = res_mid_change.drop("id")
      .withColumnRenamed("newId","id")
      .dropDuplicates("id")
      .where('id =!= "0").select('id, 'count_change)

    val res_cal = res_write_total.join(res_write_back, Seq("id"), "left")
      .join(res_write_change, Seq("id"), "left")

//    res_cal.show(20,false)
    val res_write = res_cal.withColumn("backFrequency", 'count_back / 'count)
      .withColumn("changeFrequency", 'count_change / 'count)
      .na.fill(0)
      .drop("count_back", "count", "count_change")

//    res_write.show(20,false)

//      val res_write_back_final = res_write.withColumn("row_num", row_number() over Window.orderBy('backFrequency.desc))
//      .withColumn("back", 'row_num / 969)
//      .select('id,
//        when('back <= 0.1, "高")
//          .when('back > 0.1 and 'back <= 0.8, "中")
//          .when('back > 0.8 , "低")
//          .as("back")
//      ).drop("backFrequency")

    val res_write_change_final = res_write.select('id,
      when('changeFrequency =!= 0, "中")
    .otherwise("低")
    .as("change"))

//    res_write_change_final.show(20,false)

    /** Read Total Table */
    def catalog_totalWrite_back =
      s"""{
         |"table":{"namespace":"default", "name":"totalTable"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"back":{"cf":"cf", "col":"back", "type":"string"}
         |}
         |}""".stripMargin

//    res_write_back_final.write
//      .option(HBaseTableCatalog.tableCatalog, catalog_totalWrite_back)
//          .option(HBaseTableCatalog.newTable, "5")
//          .format("org.apache.spark.sql.execution.datasources.hbase")
//          .save()

    def catalog_totalWrite_change =
      s"""{
         |"table":{"namespace":"default", "name":"totalTable"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"change":{"cf":"cf", "col":"change", "type":"string"}
         |}
         |}""".stripMargin

    res_write_change_final.write
      .option(HBaseTableCatalog.tableCatalog, catalog_totalWrite_change)
      .option(HBaseTableCatalog.newTable, "5")
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .save()

    spark.stop()
  }
}
