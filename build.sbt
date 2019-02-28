name := "Cross-Platforms-ScalaNative-JVM"

import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

val sharedSettings = Seq(scalaVersion := "2.11.12")

//lazy val foo = crossProject.crossType(CrossType.Pure).in(file("."))

lazy val bar =
// select supported platforms
  crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Full) // [Pure, Full, Dummy], default: CrossType.Full
    .settings(sharedSettings)
    .jsSettings(/* ... */ // Add JS-specific settings here
      libraryDependencies += "org.querki" %%% "jquery-facade" % "1.2") // defined in sbt-scalajs-crossproject
    .jvmSettings(/* ... */)
    // configure Scala-Native settings
    .nativeSettings(/* ... */) // defined in sbt-scala-native

// Optional in sbt 1.x (mandatory in sbt 0.13.x)
lazy val barJS     = bar.js
lazy val barJVM    = bar.jvm
lazy val barNative = bar.native
