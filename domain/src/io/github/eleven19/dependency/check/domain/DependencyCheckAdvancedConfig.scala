package io.github.eleven19.dependency.check.domain

import java.nio.file.Path
import java.net.URL

final case class DependencyCheckAdvancedConfig(
    cveUrlModified: Option[URL],
    cveUrlBase: Option[String],
    cveUser: Option[String],
    cvePassword: Option[String],
    cveWaitTime: Option[Int],
    cveStartYear: Option[Int],
    connectionTimeout: Option[Int],
    dataDirectory: Option[Path],
    databaseDriverName: Option[String],
    databaseDriverPath: Option[Path],
    connectionString: Option[String],
    databaseUser: Option[String],
    databasePassword: Option[String],
    metaFileName: Option[String]
)

object DependencyCheckAdvancedConfig {
  val default: DependencyCheckAdvancedConfig = DependencyCheckAdvancedConfig(
    cveUrlModified = None,
    cveUrlBase = None,
    cveUser = None,
    cvePassword = None,
    cveWaitTime = None,
    cveStartYear = None,
    connectionTimeout = None,
    dataDirectory = None,
    databaseDriverName = None,
    databaseDriverPath = None,
    connectionString = None,
    databaseUser = None,
    databasePassword = None,
    metaFileName = Some("dependency-check.ser")
  )
}
