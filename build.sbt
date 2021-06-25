import Dependencies._
import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

name := "scala-i18n"

organization := "org.jmotor"

scalaVersion := Versions.scala3

libraryDependencies ++= dependencies

enablePlugins(Publish)

crossScalaVersions := Seq(Versions.scala212, Versions.scala213, Versions.scala3)

dependencyUpgradeModuleNames := Map(
  "scala3-library" -> "scala3"
)

lazy val utf8: String = "UTF-8"
lazy val javaVersion: String = "1.8"

compile / javacOptions ++= Seq("-source", javaVersion, "-target", javaVersion, "-encoding", utf8, "-deprecation")
doc / javacOptions ++= Seq("-linksource", "-source", javaVersion, "-docencoding", utf8, "-charset", utf8, "-encoding", utf8, "-nodeprecated")

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  pushChanges
)
