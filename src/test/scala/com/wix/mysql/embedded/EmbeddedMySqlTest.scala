package com.wix.mysql.embedded

import org.specs2.mutable.Specification
import java.io.File
import org.specs2.matcher.FileMatchers

/**
 * @author shaiyallin
 * @since 3/20/14
 */

class EmbeddedMySqlTest extends Specification with FileMatchers {

  "embedded mysql" should {
    "start and stop properly" in {
      val config = new Config()
      val mysql = new EmbeddedMySql(config)

      val rs = mysql.dataSource.getConnection.prepareStatement("select 1").executeQuery()
      rs.next() must beTrue
      rs.getInt(1) must_== 1

      mysql.stop()

      config.dbDir.getAbsolutePath + "/data" must not(beAnExistingPath)
    }

  }
}