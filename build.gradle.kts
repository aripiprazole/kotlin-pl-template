import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
  kotlin("multiplatform") version "1.8.21" apply false
  kotlin("plugin.serialization") version "1.8.21" apply false
  id("org.jlleitschuh.gradle.ktlint") version "10.3.0" apply false
  id("io.gitlab.arturbosch.detekt") version "1.19.0" apply false
}

group = "dev.aripiprazole"
version = "0.0.1"

subprojects {
  apply(plugin = "org.jetbrains.kotlin.multiplatform")
  apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
  apply(plugin = "org.jlleitschuh.gradle.ktlint")
  apply(plugin = "io.gitlab.arturbosch.detekt")

  repositories {
    mavenCentral()
  }

  configure<KtlintExtension> {
    version.set("0.45.2")
    android.set(false)
    additionalEditorconfigFile.set(rootProject.file(".editorconfig"))
  }

  configure<DetektExtension> {
    buildUponDefaultConfig = true
    allRules = false

    config = files("${rootProject.projectDir}/config/detekt.yml")
    baseline = file("${rootProject.projectDir}/config/baseline.xml")
  }

  configure<KotlinMultiplatformExtension> {
    jvmToolchain(11)

    sourceSets {
      all {
        afterEvaluate {
          kotlin.setSrcDirs(listOf("${project.projectDir}/${this@all.name.replace("Main", "")}"))
        }
        languageSettings {
          optIn("kotlin.RequiresOptIn")
          optIn("kotlin.contracts.ExperimentalContracts")
        }
      }
    }
  }
}
