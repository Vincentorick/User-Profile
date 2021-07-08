package net.suncaper.userprofileTest.model

import com.alibaba.fastjson.JSON
import org.apache.calcite.avatica.org.apache.http.client.methods.HttpGet
import org.apache.calcite.avatica.org.apache.http.impl.client.HttpClients
import org.apache.calcite.avatica.org.apache.http.util.EntityUtils
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog

/**
 *
 *   Use fastjson and a type of geometry API
 *   to get the area
 *   by mobile number.
 *
 * */

object OriginModel {

  def main(args: Array[String]): Unit = {

    def catalog =
    s"""{
       |  "table":{"namespace":"default", "name":"tbl_users"},
       |  "rowkey":"id",
       |  "columns":{
       |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
       |    "mobile":{"cf":"cf", "col":"mobile", "type":"string"}
       |  }
       |}""".stripMargin

    val spark = SparkSession.builder()
      .appName("HBase")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val source = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load().createOrReplaceTempView("temp_table")

    /**
     * usage of the fastjson and API
     * */
    val getCity = (phone: String) => {
      val httpClient = HttpClients.createDefault
      val httpGet = new HttpGet(s"http://cx.shouji.360.cn/phonearea.php?number=${phone}")
      val httpResponse = httpClient.execute(httpGet)
      val response = EntityUtils.toString(httpResponse.getEntity, "UTF-8")
      val data = JSON.parseObject(response).get("data").toString
      val city = JSON.parseObject(data).get("province").toString
      httpGet.releaseConnection()
      httpClient.close()
      city
    }

    spark.udf.register("getCity", getCity)

    val res = spark.sql(
      """select id, getCity(mobile) as origin
        | from temp_table
      """.stripMargin)

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"renkoushuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"origin":{"cf":"cf", "col":"origin", "type":"string"}
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
