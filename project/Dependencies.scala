import sbt._

object Dependencies {

  object Versions {
    val scala211 = "2.11.8"
    val scala212 = "2.12.0"
    val scalaTest = "3.0.0"
    val scalaLogging = "3.5.0"
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