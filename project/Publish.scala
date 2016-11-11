import sbt.Keys._
import sbt._
import sbt.{AutoPlugin, Credentials, Path, PluginTrigger}

object Publish extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[_root_.sbt.Def.Setting[_]] = Seq(
    publishMavenStyle := true,
    publishTo := {
      val nexus = "http://54.223.132.19:8081"
      if (isSnapshot.value) {
        Some("snapshots" at nexus + "/nexus/content/repositories/snapshots/")
      } else {
        Some("releases" at nexus + "/nexus/content/repositories/releases/")
      }
    },
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )
}