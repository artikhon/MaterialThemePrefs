buildscript {
    extra["android_min_sdk_version"] = 21
    extra["android_compile_sdk_version"] = 34
    extra["jdk_version"] = 17
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
        classpath("com.android.tools.build:gradle:8.3.0")
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.6.0")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}