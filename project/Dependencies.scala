import sbt._

object Dependencies {

  object Versions {
    val scala212 = "2.12.8"
    val scala213 = "2.13.0"
    val scala211 = "2.11.11"
    val scalatest = "3.0.8"
  }

  object Compile {
  }

  object Test {
    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalatest % "test"
  }

  lazy val dependencies: Seq[ModuleID] = Seq(Test.scalaTest)

}
