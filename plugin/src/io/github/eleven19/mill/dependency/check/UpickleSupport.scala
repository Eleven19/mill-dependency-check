package io.github.eleven19.mill.dependency.check
import io.github.eleven19.dependency.check.domain._
import upickle.default._
import java.net.URL
import mill.api.PathRef
import java.nio.file.Path

trait UpickleSupport {
  implicit val urlRW: ReadWriter[URL] =
    readwriter[String].bimap[URL](_.toString, new URL(_))
  implicit val pathRW: ReadWriter[Path] =
    readwriter[PathRef].bimap((p: Path) => PathRef(os.Path(p)), _.path.wrapped)

  implicit val DependencyCheckAdvancedConfigRW
      : ReadWriter[DependencyCheckAdvancedConfig] = macroRW

  implicit val DependencyCheckAnalyzerConfigRW
      : ReadWriter[DependencyCheckAnalyzerConfig] = macroRW

  implicit val DependencyCheckConfigRW: ReadWriter[DependencyCheckConfig] =
    macroRW
}
object UpickleSupport extends UpickleSupport
