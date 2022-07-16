package io.github.eleven19.mill.dependency.check
import mill.api.PathRef
import mill.{Agg, T}
import mill.scalalib.JavaModule
import org.owasp.dependencycheck.utils.Settings
import io.github.eleven19.dependency.check.domain._

trait DependencyCheckJavaModule extends JavaModule { self =>
  import UpickleSupport._

  def dependencyCheckPropertyFiles = T.sources {
    Seq(
      PathRef(self.millSourcePath / "dependency-check.properties"),
      PathRef(T.workspace / "dependency-check.properties")
    )
  }

  def dependencyCheckPropertyFilesResolved = T {
    val propertyFiles = dependencyCheckPropertyFiles()
    propertyFiles.collect({
      case p if os.exists(p.path) => p
    })
  }

  def dependencyCheckConfig = T {
    val config = DependencyCheckConfig.default
    config
  }

  def dependencyCheckSettings(config: DependencyCheckConfig): Settings = {
    val settings = new Settings()
    settings
  }

  def dependencyCheckAnalyze = T {
    val config = dependencyCheckConfig()
    val settings = dependencyCheckSettings(config)
    ""
  }

  def useModuleNameAsGav: T[Option[Boolean]] = T { None }
}
