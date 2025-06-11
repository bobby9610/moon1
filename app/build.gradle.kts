plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.moonnet"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.moonnet"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release { /* your release config */ }
        debug { /* your debug config */ }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.kotlinx.coroutines.android)
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
}