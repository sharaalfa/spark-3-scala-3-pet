import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark._
import org.apache.spark.sql.functions.{col, monotonically_increasing_id}
import zio._

object SparkScala3Example {

  def main(args: Array[String]): Unit = {
 //   new SparkConf().setAll()
    val spark = SparkSession.builder
      .appName("Spark Scala 3 Example")
      .getOrCreate()

    import spark.implicits._

   /* val data = Seq(("James", "Smith", "USA", "CA"),
      ("Michael", "Rose", "USA", "NY"),
      ("Robert", "Williams", "USA", "CA"),
      ("Maria", "Jones", "USA", "FL")
    )

    val columns = Seq("firstname", "lastname", "country", "state")
    val df: DataFrame = data.toDF("firstname", "lastname", "country", "state")
    val df1: DataFrame = df.withColumn("ordernumber", monotonically_increasing_id())

    for {
      last <- df1.select("ordernumber").collect().toList
    } last.getLong(0)
    val last = df1.select("ordernumber").collect().toList.last.getLong(0)
    for (i <- 0 to last.toInt by 1) {
      var df2 = df1.where(col("ordernumber") <  i.toLong)
      df2.show()
    }
    df.show()
    df.select("lastname").map(r => r(0).asInstanceOf[String]).first()

    spark.stop()*/

    val ds1 = Seq(("a", 1), ("b", 2)).toDF("key", "value")
    val ds2 = Seq(("c", 3), ("d", 4)).toDF("key", "value")
    val ds3 = Seq(("k", 5), ("n", 6)).toDF("key", "value")
    val l = List(ds1, ds2, ds3)

    // Perform union operation
    val unionDs = l.reduce(_ union _)//ds1.union(ds2)

    // Show the result
    unionDs.show()

    spark.stop()
  }
}
