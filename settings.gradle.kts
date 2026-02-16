pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "QuitGlow"
include(":app")
include(":core:domain")
include(":core:data")
include(":core:di")
include(":core:navigation")
include(":core:ui")
include(":core:designsystem")
include(":feature:onboarding:domain")
include(":feature:onboarding:data")
include(":feature:onboarding:presentation")
include(":feature:home:domain")
include(":feature:home:data")
include(":feature:home:presentation")
include(":feature:craving:domain")
include(":feature:craving:data")
include(":feature:craving:presentation")
include(":feature:logbook:domain")
include(":feature:logbook:data")
include(":feature:logbook:presentation")
include(":feature:stats:domain")
include(":feature:stats:data")
include(":feature:stats:presentation")
include(":feature:achievements:domain")
include(":feature:achievements:data")
include(":feature:achievements:presentation")
include(":feature:settings:domain")
include(":feature:settings:data")
include(":feature:settings:presentation")
