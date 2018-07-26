import sbt._

object Dependencies {

  object Versions {
    val scala212 = "2.12.6"
    val scala211 = "2.11.8"
    val scalatest = "3.0.5"
  }

  object Compile {
  }

  object Test {
    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalatest % "test"
  }

  lazy val dependencies = Seq(Test.scalaTest)

}