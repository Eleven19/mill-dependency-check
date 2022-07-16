import mill._, scalalib._
import $exec.plugins
import io.github.eleven19.dependency.check.domain._
import io.github.eleven19.mill.dependency.check.DependencyCheckJavaModule
import mill.eval.Evaluator
import $ivy.`org.scalameta::munit:0.7.29`
import munit.Assertions._

object minimal extends ScalaModule with DependencyCheckJavaModule {
  def scalaVersion = "3.1.3"

  def ivyDeps = Agg(ivy"com.lihaoyi::pprint:0.7.3")

  object test extends Tests with TestModule.Munit {
    def ivyDeps = Agg(ivy"org.scalameta::munit:0.7.29")
  }
}

def verify(ev: Evaluator) = T.command {
  val config = minimal.dependencyCheckConfig()
  assertEquals(config, DependencyCheckConfig.default)
//   val expected = ujson.read(os.read(os.pwd / "manifests.json"))

//   val manifestMapping = Graph.generate(ev)()

//   // Lil hacky but if we compare the strings they won't match, so we read that
//   // back up into a ujson.Value so we can compare those two
//   val result = ujson.read(upickle.default.write(manifestMapping))

  assertEquals(1, 1)
}
