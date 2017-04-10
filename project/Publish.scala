import sbt.Keys._
import sbt._
import sbt.{AutoPlugin, Credentials, Path, PluginTrigger}

object Publish extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[_root_.sbt.Def.Setting[_]] = Seq(
    publishMavenStyle := true,
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value) {
        Some("snapshots" at nexus + "content/repositories/snapshots")
      }
      else {
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
      }
    },
    pomExtra :=
      <url>https://github.com/aiyanbo/scala-i18n</url>
        <licenses>
          <license>
            <name>Apache License</name>
            <url>http://www.apache.org/licenses/</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:aiyanbo/scala-i18n.git</url>
          <connection>scm:git:git@github.com:aiyanbo/scala-i18n.git</connection>
        </scm>
        <developers>
          <developer>
            <id>yanbo.ai</id>
            <name>Andy Ai</name>
            <url>http://aiyanbo.github.io/</url>
          </developer>
        </developers>
  )
}