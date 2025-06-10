// Remove or comment out this line:
// import org.gradle.internal.impldep.org.jsoup.Connection

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
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

        // tells Gradle which runner to use for instrumentation tests
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildFeatures {
        viewBinding = true
    }

    // Optional: use AndroidX Test Orchestrator for isolated tests
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
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test:runner:1.6.2")

    // Espresso — core APIs for UI testing
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    // (Optional) if you need intents validation
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")

}

