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
include(":shopping:core_shopping")
include(":shopping:core_shopping:core_shopping_api")
include(":shopping:core_shopping:core_shopping_impl")
include(":core_auth")
include(":core_auth:core_auth_api")
include(":core_auth:core_auth_impl")
