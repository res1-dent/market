object Dependencies {

    const val composeCompilerVersion = "1.4.0"

    const val composeVersion = "1.7.1"
    private const val composeBomVersion = "2022.10.00"
    private const val composeViewModelVersion = "2.6.1"

    val compose = listOf<String>(
        "androidx.compose.ui:ui",
        "androidx.activity:activity-compose:$composeVersion",
        "androidx.compose.ui:ui",
        "androidx.compose.ui:ui-graphics",
        "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"
    )

    private const val coilVersion = "2.4.0"
    const val coil = "io.coil-kt:coil-compose:$coilVersion"

    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeDebugPreview = "androidx.compose.ui:ui-tooling"

    private const val navVersion = "2.5.3"
    const val navigation = "androidx.navigation:navigation-compose:$navVersion"

    val composeBom = "androidx.compose:compose-bom:$composeBomVersion"

    private const val coreKtxVersion = "1.10.0"
    internal const val lifecycleVersion = "2.6.1"

    val ktx = listOf(
        "androidx.core:core-ktx:$coreKtxVersion",
        "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    )

    private const val daggerVersion = "2.45"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"

    const val material = "androidx.compose.material3:material3:1.1.1"

    private const val coroutinesVersion = "1.6.4"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

    private const val firebaseVersion = "32.1.0"
    private const val firebaseAuthVersion = "22.0.0"
    const val firebaseBom = "com.google.firebase:firebase-bom:$firebaseVersion"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx:$firebaseAuthVersion"
    val firestore = listOf(
        "com.google.firebase:firebase-firestore-ktx",
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
    )

    private const val retrofitVersion = "2.9.0"
    private const val okhttpVersion = "4.9.1"

    val network = listOf(
        "com.squareup.retrofit2:retrofit:$retrofitVersion",
        "com.squareup.retrofit2:converter-gson:$retrofitVersion",
        "com.squareup.okhttp3:okhttp:$okhttpVersion",
        "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
    )


    //const val gson = "com.google.code.gson:gson:2.8.8"

}