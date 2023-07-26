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
include(":core_auth")
include(":core_auth:core_auth_api")
include(":core_auth:core_auth_impl")
include(":rus_quality:core_rus_quality")
include(":rus_quality:core_rus_quality:core_rus_quality_api")
include(":rus_quality:core_rus_quality:core_rus_quality_impl")
include(":rus_quality:feature_rus_quality")
