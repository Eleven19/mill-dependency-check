import mill._
import scalalib._
import scalafmt._
import publish._
import mill.scalalib.publish._
import mill.scalalib.api.ZincWorkerUtil
import $ivy.`com.goyeau::mill-scalafix::0.2.10`
import com.goyeau.mill.scalafix.ScalafixModule
import $ivy.`com.lihaoyi::mill-contrib-buildinfo:$MILL_VERSION`
import mill.contrib.buildinfo.BuildInfo
import mill.scalalib.api.Util.scalaNativeBinaryVersion
import $ivy.`de.tototec::de.tobiasroeser.mill.integrationtest::0.6.1`
import de.tobiasroeser.mill.integrationtest._
import $ivy.`de.tototec::de.tobiasroeser.mill.vcs.version::0.1.4`
import de.tobiasroeser.mill.vcs.version.VcsVersion

// TODO Should probably drop this to 0.10.0, but when I did a bunch of stuff breaks
val millVersion = "0.10.3"
val scala213 = "2.13.8"
val artifactBase = "mill-dependency-check"

def millBinaryVersion(millVersion: String) = scalaNativeBinaryVersion(
  millVersion
)

trait Common
    extends ScalaModule
    with PublishModule
    with ScalafixModule
    with ScalafmtModule {

  def publishVersion = VcsVersion.vcsState().format()

  def pomSettings = PomSettings(
    description = "Submit your mill project's dependency graph to GitHub",
    organization = "io.github.eleven19",
    url = "https://github.com/eleven19/mill-dependency-check",
    licenses = Seq(License.`Apache-2.0`),
    versionControl = VersionControl
      .github(owner = "eleven19", repo = "mill-dependency-check"),
    developers = Seq(
      Developer("DamianReeves", "Damian Reeves", "https://www.damianreeves.com")
    )
  )

  def scalaVersion = scala213

  def scalacOptions = Seq("-Ywarn-unused", "-deprecation")

  def scalafixIvyDeps = Agg(ivy"com.github.liancheng::organize-imports:0.6.0")

  def scalafixScalaBinaryVersion = ZincWorkerUtil.scalaBinaryVersion(scala213)
}

object domain extends Common {
  override def artifactName = "dependency-check-domain"
}

object plugin extends Common with BuildInfo {

  override def artifactName =
    s"${artifactBase}_mill${millBinaryVersion(millVersion)}"

  override def moduleDeps = Seq(domain)
  override def compileIvyDeps = super.compileIvyDeps() ++ Agg(
    ivy"com.lihaoyi::mill-scalalib:$millVersion"
  )

  override def ivyDeps = super.ivyDeps() ++ Agg(
    ivy"org.owasp:dependency-check-core:7.1.1"
  )

  override def buildInfoMembers = Map(
    "homepage" -> pomSettings().url,
    "version" -> publishVersion()
  )
  override def buildInfoObjectName = "BuildInfo"
  override def buildInfoPackageName = Some(
    "io.github.eleven19.mill.dependency.check"
  )
}

object itest extends MillIntegrationTestModule {

  def millTestVersion = millVersion

  def pluginsUnderTest = Seq(plugin)

  def testBase = millSourcePath / "src"

  override def testInvocations: T[Seq[(PathRef, Seq[TestInvocation.Targets])]] =
    T {
      Seq(
        PathRef(testBase / "minimal") -> Seq(
          TestInvocation.Targets(
            Seq("checkManifest"),
            noServer = true
          ),
          TestInvocation.Targets(
            Seq("checkPropertyFilePaths"),
            noServer = true
          )
        )
        // PathRef(testBase / "directRelationship") -> Seq(
        //   TestInvocation.Targets(Seq("verify"), noServer = true)
        // ),
        // PathRef(testBase / "eviction") -> Seq(
        //   TestInvocation.Targets(Seq("verify"), noServer = true)
        // ),
        // PathRef(testBase / "range") -> Seq(
        //   TestInvocation.Targets(Seq("verify"), noServer = true)
        // ),
        // PathRef(testBase / "reconciledRange") -> Seq(
        //   TestInvocation.Targets(Seq("verify"), noServer = true)
        // )
      )
    }
}
