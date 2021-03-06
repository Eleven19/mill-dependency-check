package io.github.eleven19.dependency.check.domain

import java.nio.file.Path
import java.net.URL

final case class DependencyCheckAnalyzerConfig(
    archiveAnalyzerEnabled: Option[Boolean],
    zipExtensions: Option[String],
    jarAnalyzerEnabled: Option[Boolean],
    centralAnalyzerEnabled: Option[Boolean],
    centralAnalyzerUseCache: Option[Boolean],
    ossIndexAnalyzerEnabled: Option[Boolean],
    ossIndexAnalyzerUrl: Option[URL],
    ossIndexAnalyzerUseCache: Option[Boolean],
    ossIndexWarnOnlyOnRemoteErrors: Option[Boolean],
    ossIndexAnalyzerUsername: Option[String],
    ossIndexAnalyzerPassword: Option[String],
    nexusAnalyzerEnabled: Option[Boolean],
    nexusAnalyzerUrl: Option[URL],
    nexusUrl: Option[URL],
    nexusUsesProxy: Option[Boolean],
    nexusUser: Option[String],
    nexusPassword: Option[String],
    pyDistributionAnalyzerEnabled: Option[Boolean],
    pyPackageAnalyzerEnabled: Option[Boolean],
    rubyGemsAnalyzerEnabled: Option[Boolean],
    openSslAnalyzerEnabled: Option[Boolean],
    cmakeAnalyzerEnabled: Option[Boolean],
    autoconfAnalyzerEnabled: Option[Boolean],
    pipAnalyzerEnabled: Option[Boolean],
    pipFileAnalyzerEnabled: Option[Boolean],
    composeAnalyzerEnabled: Option[Boolean],
    cpanFileAnalyzerEnabled: Option[Boolean],
    nodeAnalyzerEnabled: Option[Boolean],
    nodePackageSkipDependencies: Option[Boolean],
    nodeAuditAnalyzerEnabled: Option[Boolean],
    nodeAuditAnalyzerUrl: Option[URL],
    nodeAuditSkipDependencies: Option[Boolean],
    nodeAuditAnalyzerUseCache: Option[Boolean],
    npmCPEAnalyzerEnabled: Option[Boolean],
    yarnAuditAnalyzerEnabled: Option[Boolean],
    pathToYarn: Option[Path],
    pnpmAuditAnalyzerEnabled: Option[Boolean],
    pathToPNPM: Option[Path],
    nuspecAnalyzerEnabled: Option[Boolean],
    nugetConfAnalyzerEnabled: Option[Boolean],
    cocopodsAnalyzerEnabled: Option[Boolean],
    mixAuditAnalyzerEnabled: Option[Boolean],
    mixAuditPath: Option[Path],
    swiftEnabled: Option[Boolean],
    swiftPackageResolvedAnalyzerEnabled: Option[Boolean],
    bundleAuditEnabled: Option[Boolean],
    pathToBundleAudit: Option[Path],
    bundleAuditWorkingDirectory: Option[Path],
    assemblyAnalyzerEnabled: Option[Boolean],
    msbuildAnalyzerEnabled: Option[Boolean],
    peAnalyzerEnabled: Option[Boolean],
    pathToDotNETCore: Option[Path],
    retireJSAnalyzerEnabled: Option[Boolean],
    retireJSAnalyzerRepoJSUrl: Option[URL],
    retireJSAnalyzerRepoValidFor: Option[Int],
    retireJSAnalyzerFilters: Seq[String],
    retireJSAnalyzerFilterNonVulnerable: Option[Boolean],
    artifactoryAnalyzerEnabled: Option[Boolean],
    artifactoryAnalyzerUrl: Option[URL],
    artifactoryAnalyzerUseProxy: Option[Boolean],
    artifactoryAnalyzerParallelAnalysis: Option[Boolean],
    artifactoryAnalyzerUsername: Option[String],
    artifactoryAnalyzerApiToken: Option[String],
    artifactoryAnalyzerBearerToken: Option[String],
    golangDepEnabled: Option[Boolean],
    golangModEnabled: Option[Boolean],
    pathToGolangDep: Option[Path]
)

object DependencyCheckAnalyzerConfig {
  val default: DependencyCheckAnalyzerConfig = DependencyCheckAnalyzerConfig(
    archiveAnalyzerEnabled = None,
    zipExtensions = None,
    jarAnalyzerEnabled = None,
    centralAnalyzerEnabled = Some(false),
    centralAnalyzerUseCache = None,
    ossIndexAnalyzerEnabled = None,
    ossIndexAnalyzerUrl = None,
    ossIndexAnalyzerUseCache = None,
    ossIndexWarnOnlyOnRemoteErrors = None,
    ossIndexAnalyzerUsername = None,
    ossIndexAnalyzerPassword = None,
    nexusAnalyzerEnabled = None,
    nexusAnalyzerUrl = None,
    nexusUrl = None,
    nexusUsesProxy = None,
    nexusUser = None,
    nexusPassword = None,
    pyDistributionAnalyzerEnabled = None,
    pyPackageAnalyzerEnabled = None,
    rubyGemsAnalyzerEnabled = None,
    openSslAnalyzerEnabled = None,
    cmakeAnalyzerEnabled = None,
    autoconfAnalyzerEnabled = None,
    pipAnalyzerEnabled = None,
    pipFileAnalyzerEnabled = None,
    composeAnalyzerEnabled = None,
    cpanFileAnalyzerEnabled = None,
    nodeAnalyzerEnabled = None,
    nodePackageSkipDependencies = None,
    nodeAuditAnalyzerEnabled = None,
    nodeAuditAnalyzerUrl = None,
    nodeAuditSkipDependencies = None,
    nodeAuditAnalyzerUseCache = None,
    npmCPEAnalyzerEnabled = None,
    yarnAuditAnalyzerEnabled = None,
    pathToYarn = None,
    pnpmAuditAnalyzerEnabled = None,
    pathToPNPM = None,
    nuspecAnalyzerEnabled = None,
    nugetConfAnalyzerEnabled = None,
    cocopodsAnalyzerEnabled = None,
    mixAuditAnalyzerEnabled = None,
    mixAuditPath = None,
    swiftEnabled = None,
    swiftPackageResolvedAnalyzerEnabled = None,
    bundleAuditEnabled = None,
    pathToBundleAudit = None,
    bundleAuditWorkingDirectory = None,
    assemblyAnalyzerEnabled = None,
    msbuildAnalyzerEnabled = None,
    peAnalyzerEnabled = None,
    pathToDotNETCore = None,
    retireJSAnalyzerEnabled = None,
    retireJSAnalyzerRepoJSUrl = None,
    retireJSAnalyzerRepoValidFor = None,
    retireJSAnalyzerFilters = Seq.empty,
    retireJSAnalyzerFilterNonVulnerable = None,
    artifactoryAnalyzerEnabled = None,
    artifactoryAnalyzerUrl = None,
    artifactoryAnalyzerUseProxy = None,
    artifactoryAnalyzerParallelAnalysis = None,
    artifactoryAnalyzerUsername = None,
    artifactoryAnalyzerApiToken = None,
    artifactoryAnalyzerBearerToken = None,
    golangDepEnabled = None,
    golangModEnabled = None,
    pathToGolangDep = None
  )
}
