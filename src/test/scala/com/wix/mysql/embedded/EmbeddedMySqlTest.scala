package com.wix.mysql.embedded

import org.specs2.mutable.Specification
import org.specs2.matcher.FileMatchers
import javax.sql.DataSource

/**
 * @author shaiyallin
 * @since 3/20/14
 */

class EmbeddedMySqlTest extends Specification with FileMatchers {

  sequential

  val config = new Config()
  val mysql = new EmbeddedMySql(config)

  def select1From(ds: DataSource) = ds.getConnection.prepareStatement("select 1").executeQuery()

  "embedded mysql" should {
    "start properly" in {
      val rs = select1From(mysql.dataSource)
      rs.next() must beTrue
      rs.getInt(1) must_== 1
    }

    "create a second database on the fly" in {
      val rs = select1From(mysql.dataSourceFor("another_db"))
      rs.next() must beTrue
      rs.getInt(1) must_== 1
    }

    "stop properly" in {
       mysql.stop()

       config.dbDir.getAbsolutePath + "/data" must not(beAnExistingPath)
    }

  }
}