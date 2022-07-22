package io.github.eleven19.mill.dependency.check
import mill.api.PathRef
import mill.define.{Command, Module, Target, Task}
import mill.{Agg, T}
import mill.scalalib.JavaModule
import org.owasp.dependencycheck.utils.Settings
import io.github.eleven19.dependency.check.domain._

trait DependencyCheckJavaModule extends JavaModule { outer =>
  import UpickleSupport._

  def dependencyCheckOutDir: T[PathRef] = T {
    PathRef(T.dest)
  }

  def dependencyCheckScanSet = T.sources { millSourcePath / "resources" }

  def dependencyCheckPropertyFiles = T.sources {
    Seq(
      PathRef(millSourcePath / "dependency-check.properties"),
      PathRef(T.workspace / "dependency-check.properties")
    )
  }

  def dependencyCheckPropertyFilesResolved = T {
    val propertyFiles = dependencyCheckPropertyFiles()
    propertyFiles.collect({
      case p if os.exists(p.path) => p
    })
  }

  def dependencyCheckConfig: T[DependencyCheckConfig] = T {
    val outputDir = dependencyCheckOutDir().path.toNIO
    val scanSet = dependencyCheckScanSet().map(_.path.toNIO)
    val config = DependencyCheckConfig.default.copy(
      outputDirectory = Some(outputDir),
      scanSet = scanSet
    )

    config
  }

  def useModuleNameAsGav: T[Option[Boolean]] = T { None }

  val dependencyCheck = new DependencyCheckData(implicitly)
  class DependencyCheckData(ctx0: mill.define.Ctx)
      extends Module()(ctx0) /* with JavaModule */ {

    def analyze = T {
      val _ = config()
      ""
    }

    def config: Target[DependencyCheckConfig] = T {
      outer.dependencyCheckConfig()
    }

    def doReport(): Task[Unit] = T.task {}

    def htmlReport(): Command[Unit] = T.command {}
  }

}
