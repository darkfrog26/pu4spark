name := "pu4spark"
organization := "com.matthicks"
version := "0.3.0-SNAPSHOT"
scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-mllib" % "1.6.2",
  "org.apache.logging.log4j" % "log4j-api" % "2.10.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.10.0"
)