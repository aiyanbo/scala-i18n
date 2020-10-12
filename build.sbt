import Dependencies._
import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

name := "scala-i18n"

organization := "org.jmotor"

scalaVersion := Versions.scala213

libraryDependencies ++= dependencies

enablePlugins(Publish)

crossScalaVersions := Seq(Versions.scala211, Versions.scala212, Versions.scala213)

dependencyUpgradeModuleNames := Map(
  "scala-library" -> "scala212"
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
