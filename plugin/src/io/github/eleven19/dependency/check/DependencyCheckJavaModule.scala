package io.github.eleven19.dependency.check
import mill.T
import mill.scalalib.JavaModule

trait DependencyCheckJavaModule extends JavaModule {
  def dependencyCheckAnalyze = T {
    ("a", "b")
  }
}
