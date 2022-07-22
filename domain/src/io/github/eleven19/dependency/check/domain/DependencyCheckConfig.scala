package io.github.eleven19.dependency.check.domain
import java.nio.file.Path

final case class DependencyCheckConfig(
    autoUpdate: Option[Boolean],
    cveValidForHours: Option[Int],
    failBuildOnCVSS: Option[Float],
    junitFailBuildOnCVSS: Option[Float],
    format: Option[String],
    formats: Seq[String],
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
  val default: DependencyCheckConfig = DependencyCheckConfig(
    autoUpdate = None,
    cveValidForHours = None,
    failBuildOnCVSS = Some(11),
    junitFailBuildOnCVSS = None,
    format = Some("HTML"),
    formats = Seq.empty,
    outputDirectory = None,
    scanSet = Seq.empty,
    skip = false,
    skipTestScope = true,
    skipRuntimeScope = false,
    skipProvidedScope = false,
    skipOptionalScope = false,
    suppressionFile = None,
    suppressionFiles = Seq.empty,
    cpeStartsWith = None,
    hintsFile = None,
    analysisTimeout = None,
    enableExperimental = None,
    enableRetired = None,
    analyzers = DependencyCheckAnalyzerConfig.default,
    advanced = DependencyCheckAdvancedConfig.default
  )
}
