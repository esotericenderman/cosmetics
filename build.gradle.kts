import org.gradle.api.JavaVersion

plugins {
  java
  `java-library`

  `maven-publish`

  id("io.papermc.paperweight.userdev") version "1.7.1"
  id("xyz.jpenilla.run-paper") version "2.3.0"
}

description = "A very simple cosmetics plugin featuring hats and trails!"

group = "dev.enderman"
version = "1.0.0"

val javaVersion = 21
val javaVersionEnum = JavaVersion.valueOf("VERSION_$javaVersion")

java {
  sourceCompatibility = javaVersionEnum
  targetCompatibility = javaVersionEnum

  toolchain.languageVersion = JavaLanguageVersion.of(javaVersion)
}

dependencies {
  paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")
}

tasks {
  compileJava {
    options.release = javaVersion
  }

  javadoc {
    options.encoding = Charsets.UTF_8.name()
  }
}
