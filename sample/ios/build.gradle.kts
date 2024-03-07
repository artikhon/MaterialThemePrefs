import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

val binConfig: KotlinNativeTarget.() -> Unit = {
    binaries {
        executable {
            entryPoint = "com.softartdev.sample.main"
        }
    }
}
kotlin {
    iosX64(binConfig)
    iosArm64(binConfig)
    iosSimulatorArm64(binConfig)
    sourceSets {
        commonMain.dependencies {
            implementation(project(":sample:shared"))
            implementation(project(":theme:theme-material"))
            implementation(project(":theme:theme-material3"))
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.runtime)
        }
    }
}
