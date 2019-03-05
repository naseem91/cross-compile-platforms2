val commonSettings = Seq(
  version        := "0.0.1",
  scalaVersion   := "2.11.8",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-target:jvm-1.7"),
  javacOptions  ++= Seq("-source", "1.7", "-target", "1.7"),
  exportJars     := true
)

lazy val android = (project in file("."))
  .enablePlugins(AndroidLib)
  .settings(commonSettings: _*)
  .settings(
    name := "sgl-android",
    platformTarget := "android-28",
    useProguard := true
  )