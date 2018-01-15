name := "pu4spark"
organization := "com.matthicks"
version := "0.3.0-SNAPSHOT"
scalaVersion := "2.11.12"
scalacOptions ++= Seq("-unchecked", "-deprecation", "-Ypartial-unification", "-Ywarn-value-discard")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-mllib" % "2.2.1",
  "org.apache.logging.log4j" % "log4j-api" % "2.10.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.10.0",
  "org.scalactic" %% "scalactic" % "3.0.4" % "test",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)