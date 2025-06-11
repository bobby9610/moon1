// Root-level build script
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("com.android.tools.build:gradle:8.9.1")
    }
}

// ✅ Move `dependencyResolutionManagement` to `settings.gradle.kts`
