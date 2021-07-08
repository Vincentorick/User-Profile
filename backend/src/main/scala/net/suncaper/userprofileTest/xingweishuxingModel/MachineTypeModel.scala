package net.suncaper.userprofileTest.xingweishuxingModel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
 *
 *  Matching OS type by
 *  matching the field
 *  user_agent.
 *
 */

object MachineTypeModel {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .master("local")
      .appName("HBaseAge")
      .getOrCreate()

    import spark.implicits._

    def catalog =
      s"""{
         |  "table":{"namespace":"default", "name":"tbl_logs"},
         |  "rowkey":"id",
         |  "columns":{
         |    "id":{"cf":"rowkey", "col":"id", "type":"string"},
         |    "user_agent":{"cf":"cf", "col":"user_agent", "type":"string"},
         |    "global_user_id":{"cf":"cf", "col":"global_user_id", "type":"string"}
         |  }
         |}""".stripMargin

    val df = spark.read
      .option(HBaseTableCatalog.tableCatalog, catalog)
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    val res_change = df
      .select('global_user_id,
      when(instr($"user_agent","Linux")=!=0 and instr($"user_agent","Android")=!=0, "Android")
        .when(instr($"user_agent","Windows NT")=!=0, "Windows")
        .when(instr($"user_agent","Mac")=!=0 or instr($"user_agent","iPhone")=!=0
          or instr($"user_agent","iPad")=!=0, "IOS")
        .when(instr($"user_agent","Linux")=!=0, "Linux")
        .otherwise("Linux")
        .as("machineType")
    )
      .withColumnRenamed("global_user_id", "id")

    res_change.groupBy('machineType).agg(count('id)).show(100,false)

    val res_write = res_change.groupBy('id, 'machineType)
      .agg(count('machineType) as "count")
      .withColumn("row_num", row_number() over Window.partitionBy('id).orderBy('count.desc))
      .where('row_num === 1)
      .drop("count", "row_num")

    res_write.select(col("id"), col("machineType"))
      .groupBy(col("machineType"))
      .agg(count(col("machineType") as "count"))

    def catalogWrite =
      s"""{
         |"table":{"namespace":"default", "name":"xingweishuxing"},
         |"rowkey":"id",
         |"columns":{
         |"id":{"cf":"rowkey", "col":"id", "type":"string"},
         |"machineType":{"cf":"cf", "col":"machineType", "type":"string"}
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
