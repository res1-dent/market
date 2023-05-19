import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {

    val composeVersion = "1.7.1"
    val composeCompilerVersion = "1.4.1"
    val composeBomVersion = "2022.10.00"

    val compose = listOf<String>(
        "androidx.compose.ui:ui",
        "androidx.activity:activity-compose:$composeVersion",
        "androidx.compose.ui:ui",
        "androidx.compose.ui:ui-graphics",
        "androidx.compose.ui:ui-tooling-preview"
    )

    val composeBom = "androidx.compose:compose-bom:$composeBomVersion"

    val coreKtxVersion = "1.10.0"
    val lifecycleVersion = "2.6.1"


    val ktx = listOf(
        "androidx.core:core-ktx:$coreKtxVersion",
            "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    )

    const val daggerVersion = "2.45"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"

    const val material = "androidx.compose.material3:material3"
}