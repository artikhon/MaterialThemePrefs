rootProject.name = "MaterialThemePrefs"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
includeBuild("convention-plugins")

include(":theme:theme-prefs")
include(":theme:theme-material")
include(":theme:theme-material3")

include(":sample:shared")
include(":sample:android")
include(":sample:desktop")
include(":sample:ios")
