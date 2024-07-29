ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "spark-3-scala-3-pet"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.5.1" % "provided",
  "org.apache.spark" %% "spark-hive" % "3.5.1" % "provided",
  "org.apache.spark" %% "spark-sql" % "3.5.1" % "provided",
  "org.apache.spark" %% "spark-mllib" % "3.5.1" % "provided",
  "dev.zio" %% "zio" % "1.0.9"
  //"io.univalence" %% "zio-spark" % "0.11.5"
)

assembly / assemblyJarName := s"${name.value}-assembly-${version.value}.jar"
// include the 'provided' Spark dependency on the classpath for <code>sbt run

Compile / run := Defaults.runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner).evaluated


// Add assembly settings
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
