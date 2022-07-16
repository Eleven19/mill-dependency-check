package io.github.eleven19.dependency.check.domain
import java.nio.file.Path

final case class DependencyCheckConfig(
    autoUpdate: Option[Boolean],
    cveValidForHours: Option[Int],
    failBuildOnCVSS: Option[Float],
    junitFailBuildOnCVSS: Option[Float],
    format: Option[String],
    formats: Option[Seq[String]],
    outputDirectory: Option[Path],
    scanSet: Seq[Path],
    skip: Boolean,
    skipTestScope: Boolean,
    skipRuntimeScope: Boolean,
    skipProvidedScope: Boolean,
    skipOptionalScope: Boolean,
    suppressionFile: Option[Path],
    suppressionFiles: Seq[Path],
    cpeStartsWith: Option[String],
    hintsFile: Option[Path],
    analysisTimeout: Option[Int],
    enableExperimental: Option[Boolean],
    enableRetired: Option[Boolean],
    analyzers: DependencyCheckAnalyzerConfig,
    advanced: DependencyCheckAdvancedConfig
)

object DependencyCheckConfig {
  val default: DependencyCheckConfig = ???
}
