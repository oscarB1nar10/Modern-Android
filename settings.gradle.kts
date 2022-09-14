pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "OpenBank"
include (":app")
include(":build-src")
include(":features")
include(":features:hero-list")
include(":features:hero-detail")
include(":libraries")
include(":libraries:core")
include(":libraries:model")
include(":libraries:comon")
include(":libraries:navigation")
include(":libraries:database")
include(":libraries:network")
include(":libraries:design-system")
include(":libraries:testing")
