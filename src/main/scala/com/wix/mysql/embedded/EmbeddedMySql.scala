package com.wix.mysql.embedded

import com.mysql.management.MysqldResource
import scala.collection.JavaConverters._
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import java.io.File

/**
 * @author shaiyallin
 * @since 3/20/14
 */

class EmbeddedMySql(config: Config) {

  def this() = this(Config.Default) // for Java interop

  val DRIVER = "com.mysql.jdbc.Driver"

  config.validate()
  val mysqld = new MysqldResource(config.dbDir)
  val dataDir = new File(config.dbDir, "data")

  def start() {
    Class.forName(DRIVER)
    mysqld.start("embedded-mysql", config.toProps.asJava)

    sys.addShutdownHook {
      stop()
    }
  }

  lazy val dataSource = dataSourceFor(config.initialDBName)

  def dataSourceFor(dbName: String) = {
    val ds = new MysqlDataSource
    import config._
    ds.setUrl(urlFor(dbName))
    ds.setUser(username)
    ds.setPassword(password)
    ds
  }

  def stop() {
    dataDir.deleteOnExit()
    mysqld.shutdown()
    while (mysqld.isRunning) { Thread.sleep(100) }
    import scala.sys.process._
    Seq("rm", "-rf", dataDir.getAbsolutePath).!
  }
}