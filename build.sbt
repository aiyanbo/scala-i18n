import Dependencies._
import ReleaseTransformations._

name := "scala-i18n"

organization := "org.jmotor"

scalaVersion := Versions.scala213

libraryDependencies ++= dependencies

enablePlugins(Publish)

crossScalaVersions := Seq(Versions.scala211, Versions.scala212, Versions.scala213)

dependencyUpgradeModuleNames := Map(
  "scala-library" -> "scala212"
)

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
