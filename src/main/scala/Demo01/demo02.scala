package Demo01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object demo02 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WC").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val lineRDD: RDD[String] = sc.textFile("src/datas/1.txt")

    lineRDD.flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_)
      .collect()
      .foreach(println)
    sc.stop()
  }
}
