lazy val `scala 211` = "2.11.12"
lazy val `scala 212` = "2.12.10"
lazy val `scala 213` = "2.13.1"

organization := "com.chriskite"
organizationName := "Chris Kite"
startYear := Some(2019)
licenses += ("MIT", new URL("https://github.com/chriskite/log4zio/blob/master/LICENSE"))
homepage := Some(url("https://github.com/chriskite/log4zio"))

name := "log4zio"

scalaVersion := `scala 213`
crossScalaVersions := Seq(`scala 211`, `scala 212`, `scala 213`)

lazy val mainDependencies = Seq(
  "dev.zio" %% "zio" % "1.0.0-RC16",
  "io.laserdisc" %% "log-effect-zio" % "0.12.0"
)

lazy val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.log4s" %% "log4s-testing" % "1.8.2" % Test
)

libraryDependencies ++= mainDependencies ++ testDependencies

parallelExecution in Test := false
fork := true

publishTo := sonatypePublishTo.value

lazy val myProject = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin)

