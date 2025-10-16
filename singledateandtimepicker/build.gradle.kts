plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
    id("signing")
    id("org.jetbrains.dokka") version "2.1.0"
}


val PUBLISH_GROUP_ID: String by extra("se.warting.datepicker")
val PUBLISH_VERSION: String by extra(rootProject.version as String)
val PUBLISH_ARTIFACT_ID by extra("singledateandtimepicker")

apply(from = "${rootProject.projectDir}/gradle/publish-module.gradle")

android {
    compileSdk = 32

    defaultConfig {
        minSdk=  14
    }
    lint {
        baseline = file("lint-baseline.xml")
        checkReleaseBuilds = true
        checkAllWarnings = true
        warningsAsErrors = true
        abortOnError = true
        disable.add("LintBaseline")
        disable.add("GradleDependency")
        checkDependencies = true
        checkGeneratedSources = false
        sarifOutput = file("../lint-results-lib.sarif")
    }
    namespace = "com.github.florent37.singledateandtimepicker"
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.1")
}
