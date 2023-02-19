import org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
}
val binConfig: org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit = {
    binaries {
        executable {
            entryPoint = "com.softartdev.sample.main"
            freeCompilerArgs += listOf(
                "-linker-option", "-framework", "-linker-option", "Metal",
                "-linker-option", "-framework", "-linker-option", "CoreText",
                "-linker-option", "-framework", "-linker-option", "CoreGraphics"
            )
        }
    }
}
kotlin {
    iosX64("uikitX64", binConfig)
    iosArm64("uikitArm64", binConfig)
    iosSimulatorArm64("uikitSimulatorArm64", binConfig)
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":material-theme-prefs"))
                implementation(project(":sample-shared"))
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation("dev.icerock.moko:resources:${rootProject.extra["moko_resources_version"]}")
            }
        }
        val uikitX64Main by getting
        val uikitArm64Main by getting
        val uikitSimulatorArm64Main by getting
        val uikitMain by creating {
            dependsOn(commonMain)
            uikitX64Main.dependsOn(this)
            uikitArm64Main.dependsOn(this)
            uikitSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
        }
    }
}
kotlin {
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.all {
            // TODO: the current compose binary surprises LLVM, so disable checks for now.
            freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
        }
    }
}
multiplatformResources {
    multiplatformResourcesPackage = "com.sofartdev.sample"
}
//TODO try to remove after update moko-resources version > 0.20.1
val generateMRAction: Action<Task> = Action {
    mustRunAfter(":material-theme-prefs:generateMRcommonMain")
    mustRunAfter(":material-theme-prefs:generateMRiosX64Main")
    mustRunAfter(":material-theme-prefs:generateMRiosSimulatorArm64Main")
    mustRunAfter(":material-theme-prefs:generateMRiosArm64Main")
    mustRunAfter(":sample-ios:generateMRuikitX64Main")
    mustRunAfter(":sample-ios:generateMRuikitSimulatorArm64Main")
    mustRunAfter(":sample-ios:generateMRuikitArm64Main")
}
sequenceOf(ProcessResources::class, KotlinNativeCompile::class).forEach {
    tasks.withType(it.java, generateMRAction)
}