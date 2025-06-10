// 1️⃣ Imports at the very top
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

// 2️⃣ Load your keystore credentials
val keystorePropsFile = rootProject.file("keystore")
val keystoreProps = Properties().apply {
    load(keystorePropsFile.inputStream())
}

android {
    namespace = "com.example.moonnet"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.moonnet"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // 3️⃣ Signing config for release
    signingConfigs {
        create("release") {
            storeFile     = file(keystoreProps["storeFile"]    as String)
            storePassword = keystoreProps["storePassword"]      as String
            keyAlias      = keystoreProps["keyAlias"]           as String
            keyPassword   = keystoreProps["keyPassword"]        as String
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig   = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            // debug builds are auto-signed by Gradle
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    externalNativeBuild {
        cmake {
            path    = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    buildFeatures {
        viewBinding = true
    }

    // Optional: Orchestrator for isolated Espresso runs
    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }
}

dependencies {
    // Core & UI
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // Unit tests
    testImplementation(libs.junit)

    // AndroidX Test — JUnit rules & runners
    androidTestImplementation(libs.androidx.junit)    // e.g. "androidx.test.ext:junit:1.1.5"
    androidTestImplementation(libs.androidx.runner)
}
// e.g. "androidx.test:runner:1.5.2"

// Espresso — core & intents
