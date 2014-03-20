package com.wix.mysql.embedded

import java.io.File

/**
 * @author shaiyallin
 * @since 3/20/14
 */

case class Config(username: String = "auser",
                  password: String = "sa",
                  host: String = "localhost",
                  port: Int = 3336,
                  dbName: String = "test_db",
                  dbDir: File = TempDirResolver.tempSubdir("embedded-mysql")) {

  val url = s"jdbc:mysql:mxj://$host:$port/$dbName?server.basedir=$dbDir&createDatabaseIfNotExist=true&server.initialize-user=true"

  def validate() {

    def nonBlank(s: String) = s != null && s.trim != ""

    require(nonBlank(username), "Username must not be empty")
    require(nonBlank(password), "Password must not be empty")
    require(nonBlank(host), "Host must not be empty")
    require(nonBlank(dbName), "dbName must not be empty")
  }

  import com.mysql.management.MysqldResourceI._
  def toProps: Map[String, String] = Map(
    PORT -> port.toString,
    INITIALIZE_USER -> "true",
    INITIALIZE_USER_NAME -> username,
    INITIALIZE_PASSWORD -> password
  )
}