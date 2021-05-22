package com.jack

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SparkWorkCount4Scala {
  def main(args: Array[String]): Unit = {
    /**
     * 1、环境变量初始化-得到SparkContext
     * 2、构建LineRDD
     * 3、经过transformation和action算子处理
     * 4、stop SparkContext
     */
    /**
     * 1.环境变量初始化-得到SparkContext
     */
    val sparkConf = new SparkConf();
    sparkConf.setAppName("FirstSparkWordCount4Scala")
    sparkConf.setMaster("local[*]")
    /**
     * 相比在spark-shell中，需要自己定义一下sparkcontext上下文的对象。
     * 获取sparkcontext对象需要，需要先定义sparkconf对象，并且在该对象中设置好名字和Master的类型。
     * this is change
     */
    val sc = new SparkContext(sparkConf)
    /**
     * 2.构建lineRDD
     */
    var filePath = ""
    if(args == null|| args.length == 0){
      filePath = "G:\\Scala_data\\SparkDemo\\input.txt"
    }else{
      filePath = args(0)
    }
    var linesRDD = sc.textFile(filePath)
    /**
     * 3.经过transformation和action算子处理
     */
    val kvWcRDD = linesRDD.flatMap(s ⇒ s.split("\\s+")).map(word ⇒ (word,1)).reduceByKey((a,b) ⇒ a+b)
    kvWcRDD.foreach(println)
    /**
     * 4.stop SparkContext
     */
    sc.stop()
  }
}