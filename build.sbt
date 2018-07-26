import Dependencies._

name := "scala-i18n"

version := "1.0.5"

organization := "org.jmotor"

scalaVersion := Versions.scala212

libraryDependencies ++= dependencies

enablePlugins(Publish)

enablePlugins(Formatting)

crossScalaVersions := Seq(Versions.scala211, Versions.scala212)

dependencyUpgradeModuleNames := Map(
  "scala-library" -> "scala212"
)

