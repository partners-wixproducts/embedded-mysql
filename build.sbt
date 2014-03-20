scalaVersion := "2.10.3"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

name := "embedded-mysql"

organization := "com.wix"

version := "0.1.0-SNAPSHOT"

libraryDependencies += "mysql" % "mysql-connector-mxj" % "5.0.12" exclude("mysql", "mysql-connector-java")

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1+" % "provided"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.29" % "test"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.7" % "test"

licenses := Seq("Apache 2.0" -> url("http://www.opensource.org/licenses/Apache-2.0"))

homepage := Some(url("https://github.com/wix/embedded-mysql"))

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:wix/embedded-mysql.git</url>
    <connection>scm:git:git@github.com:wix/embedded-mysql.git</connection>
  </scm>
  <developers>
    <developer>
      <id>electricmonk</id>
      <name>Shai Yallin</name>
      <url>http://www.shaiyallin.com</url>
    </developer>
  </developers>
)

publishTo := Some("Artifactory Realm" at "http://repo.dev.wix/artifactory/libs-snapshots-local")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
