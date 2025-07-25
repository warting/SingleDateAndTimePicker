// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.11.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    //id("com.github.ben-manes.versions") version "0.39.0"
    //id("io.gitlab.arturbosch.detekt") version "1.18.1"
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
    //id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.7.1"
    id("com.gladed.androidgitversion") version "0.4.14"
}


androidGitVersion {
    tagPattern = "^v[0-9]+.*"
}

val gitOrLocalVersion: String =
        com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir)
                .getProperty("VERSION_NAME", androidGitVersion.name().replace("v", ""))

version = gitOrLocalVersion


allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

apply(from = "${rootDir}/gradle/publish-root.gradle")