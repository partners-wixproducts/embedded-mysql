scalaVersion := "2.10.3"

name := "embedded-mysql"

organization := "com.wix"

libraryDependencies += "mysql" % "mysql-connector-mxj" % "5.0.12" exclude("mysql", "mysql-connector-java")

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1+" % "provided"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.29" % "test"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.7" % "test"

