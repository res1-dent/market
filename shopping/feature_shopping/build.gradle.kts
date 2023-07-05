plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    namespace = "ru.hometech.marketgotogether"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    @Suppress("UnstableApiUsage")
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.composeCompilerVersion
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(":core_common"))
    implementation(project(":shopping:core_shopping"))
    implementation(project(":core_auth"))
    implement(Dependencies.ktx)
    implementation(Dependencies.composeBom)
    implement(Dependencies.compose)
    debugImplementation(Dependencies.composeDebugPreview)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.navigation)
    implement(Dependencies.material)
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerCompiler)
    implementation(platform(Dependencies.firebaseBom))
    implement(Dependencies.firestore)
    implementation(Dependencies.coroutines)
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}