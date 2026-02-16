import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
}

extra.apply {
    set("compileSdk", 36)
    set("minSdk", 24)
    set("targetSdk", 36)

    set("javaVersion", JavaVersion.VERSION_11)
    set("kotlinJvmTarget", "11")
}

subprojects {
    // ---- Android Application
    plugins.withId("com.android.application") {
        extensions.configure<com.android.build.api.dsl.ApplicationExtension>("android") {
            compileSdk = rootProject.extra["compileSdk"] as Int

            defaultConfig {
                minSdk = rootProject.extra["minSdk"] as Int
                targetSdk = rootProject.extra["targetSdk"] as Int
            }

            compileOptions {
                val javaVersion = rootProject.extra["javaVersion"] as JavaVersion
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }
        }
    }

    // ---- Android Library
    plugins.withId("com.android.library") {
        extensions.configure<com.android.build.api.dsl.LibraryExtension>("android") {
            compileSdk = rootProject.extra["compileSdk"] as Int

            defaultConfig {
                minSdk = rootProject.extra["minSdk"] as Int
            }

            compileOptions {
                val javaVersion = rootProject.extra["javaVersion"] as JavaVersion
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }
        }
    }

    // ---- Java
    tasks.withType<JavaCompile>().configureEach {
        val javaVersion = (rootProject.extra["javaVersion"] as JavaVersion).toString()
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    // ---- Kotlin (Android + JVM)
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(
                JvmTarget.fromTarget(
                    rootProject.extra["kotlinJvmTarget"] as String
                )
            )
        }
    }
}