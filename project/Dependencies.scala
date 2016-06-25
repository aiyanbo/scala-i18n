import sbt._

object Dependencies {

  object Versions {
    val scala = "2.11.8"
    val scalaTest = "2.2.6"
    val scalaLogging = "3.4.0"
  }

  object Compile {
    val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % Versions.scalaLogging
  }

  object Test {
    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest % "test"
  }

  import Compile._

  lazy val dependencies = Seq(scalaLogging, Test.scalaTest)

}