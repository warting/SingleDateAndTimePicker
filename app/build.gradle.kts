plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 14
        targetSdk = 28
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
    }

    // The demo-app uses butterknife which require java8
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    namespace = "com.github.florent37.sample.singledateandtimepicker"
    android {
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
            sarifOutput = file("../lint-results-app.sarif")
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")
    implementation("com.jakewharton:butterknife:10.2.3")
    annotationProcessor("com.jakewharton:butterknife-compiler:10.2.3")
    implementation(project(":singledateandtimepicker"))
}