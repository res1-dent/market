import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {

    const val composeCompilerVersion = "1.4.0"

    internal const val composeVersion = "1.7.1"
    internal const val composeBomVersion = "2022.10.00"
    internal const val composeViewModelVersion = "2.6.1"

    val compose = listOf<String>(
        "androidx.compose.ui:ui",
        "androidx.activity:activity-compose:$composeVersion",
        "androidx.compose.ui:ui",
        "androidx.compose.ui:ui-graphics",
        //"androidx.compose.ui:ui-tooling-preview",
        "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"
    )

    internal const val navVersion = "2.5.3"
    const val navigation = "androidx.navigation:navigation-compose:$navVersion"

    val composeBom = "androidx.compose:compose-bom:$composeBomVersion"

    internal const val coreKtxVersion = "1.10.0"
    internal const val lifecycleVersion = "2.6.1"

    val ktx = listOf(
        "androidx.core:core-ktx:$coreKtxVersion",
            "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    )

    internal const val daggerVersion = "2.45"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"

    const val material = "androidx.compose.material3:material3:1.1.0"
}