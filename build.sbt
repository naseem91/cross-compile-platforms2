name := "Cross-Platforms-ScalaNative-JVM"

import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

val sharedSettings = Seq(scalaVersion := "2.11.12")

// Android cannot run on Java8 so we stick with 2.11 and Java7. We
// need to build core separately for the right version.
val commonAndroidSettings = Seq(
  scalaVersion := "2.11.8",
  sbtVersion := "0.13.13",
  scalacOptions += "-target:jvm-1.7",
  javacOptions ++= Seq("-source", "1.7", "-target", "1.7"),
  exportJars := true
)

lazy val bar =
// select supported platforms
  crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Full) // [Pure, Full, Dummy], default: CrossType.Full
    .settings(sharedSettings)
    .settings(libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test")
    .jsSettings(/* ... */
      // Add JS-specific settings here
      libraryDependencies += "org.querki" %%% "jquery-facade" % "1.2") // defined in sbt-scalajs-crossproject
    .jvmSettings(/* ... */)
    // configure Scala-Native settings
    .nativeSettings(/* ... */) // defined in sbt-scala-native

// Optional in sbt 1.x (mandatory in sbt 0.13.x)
lazy val barJS = bar.js
lazy val barJVM = bar.jvm
lazy val barNative = bar.native

lazy val coreAndroid = (project in file("./bar"))
  .settings(commonAndroidSettings: _*)
  .settings(
    name := "barAndroid",
    target := baseDirectory.value / ".android" / "target"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"