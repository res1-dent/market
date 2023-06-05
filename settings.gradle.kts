pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "marketapp"
include(":app")
include(":core_network")
include(":core_network:core_network_api")
include(":core_network:core_network_impl")
include(":core_common")
include(":shopping:feature_shopping")
