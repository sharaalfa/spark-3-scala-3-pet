import zio._
import zio.console.Console
import org.apache.spark.sql.SparkSession

object StandaloneSparkApp extends App {

  // Define your ZIO application logic
  val myAppLogic: ZIO[Any, Throwable, Unit] =
    for {
      spark <- ZIO.succeed(ZIO.succeed(createSparkSession()))

    } yield ()

  // Define the main method using the provided ZIOAppDefault.run method
  def run = myAppLogic

  // Helper method to create a SparkSession
  def createSparkSession(): SparkSession = {
    SparkSession.builder
      .appName("Standalone Spark App")
      .getOrCreate()
  }

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = ???
}
