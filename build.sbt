import Dependencies._

name := "scala-i18n"

version := "1.0.3"

organization := "org.jmotor"

scalaVersion := Versions.scala212

libraryDependencies ++= dependencies

enablePlugins(Publish)

enablePlugins(Formatting)

scalacOptions ++= byScalaVersion {
  case (2, 12) => Seq("-opt:l:method")
  case (2, 11) => Seq("-Xexperimental")
}.value

crossScalaVersions := Seq(Versions.scala211, Versions.scala212)

def byScalaVersion[A](f: PartialFunction[(Int, Int), Seq[A]]): Def.Initialize[Seq[A]] =
  Def.setting {
    CrossVersion.partialVersion(scalaVersion.value)
      .flatMap(f.lift)
      .getOrElse(Seq.empty)
  }
