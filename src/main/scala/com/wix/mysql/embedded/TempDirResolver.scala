package com.wix.mysql.embedded

import java.io.File

/**
 * @author shaiyallin
 * @since 3/20/14
 */

object TempDirResolver {

  val TEMP_ROOT = sys.props("java.io.tmpdir")
  /*
  if (Option(sys.props("os.name")).map(_.toLowerCase).getOrElse("").startsWith("mac"))
        "/tmp"
      else
   */

  val TEMP_DIR = new File(TEMP_ROOT)

  def tempSubdir(subdir: String) = new File(TEMP_DIR, subdir)
}