import sbt._

object Dependencies {

  object Versions {
    val scala3 = "3.0.0"
    val scala213 = "2.13.6"
    val scalatest = "3.2.9"
    val scala212 = "2.12.14"
  }

  object Compile {
  }

  object Test {
    val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalatest % "test"
  }

  lazy val dependencies: Seq[ModuleID] = Seq(Test.scalaTest)

}
