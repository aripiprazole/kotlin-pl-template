import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

/*
 *    Copyright 2022 Gabrielle Guimarães de Oliveira
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

plugins {
  id("com.github.johnrengelman.shadow") version "8.1.1"
  application
}

kotlin {
  jvm()

  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.21.0")
        implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:0.21.0")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.7.2")
      }
    }
  }
}

tasks.withType<ShadowJar> {
  manifest {
    attributes["Main-Class"] = "lura.lsp.MainKt"
  }

  val target = kotlin.targets.getByName("jvm")
  from(target.compilations["main"].output)
  val runtimeClasspath = target.compilations["main"].compileDependencyFiles as Configuration
  configurations = listOf(runtimeClasspath)
}

application {
  mainClass.set("lura.lsp.MainKt")
}
