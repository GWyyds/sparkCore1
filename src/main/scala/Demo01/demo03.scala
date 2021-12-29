package Demo01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * SparkCore RDD:弹性分布式数据集
  * Rdd的五大特性:
  * 1.getPartition 表示去往哪一个分区
  * 2.compute:计算函数
  * 3.getDependencies:依赖关系,实际就是看各个RDD之间是否走shuffle
  * 4.Partitioner分区器,前提是要有shuffle,若没有shuffle,数据不会进行重新分区
  * 5.getPerferreLocations:分区存储的选取位置
  */
object demo03 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MC").setMaster("local[*]")
    val sc = new SparkContext(conf)

    //RDD的创建
    val rdd: RDD[Int] = sc.makeRDD(Array(1, 2, 3, 4, 5, 6, 4, 5, 6, 8))
  }
}
