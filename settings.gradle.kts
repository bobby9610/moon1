pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // ✅ Corrected syntax
    repositories {
        google()
        mavenCentral()
    }
}

// ✅ Ensure correct project name and module inclusion
rootProject.name = "moonnet"
include(":app")
