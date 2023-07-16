
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "ru.hometech.core_common"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
}
dependencies {
    implementation(kotlin("reflect"))
    implement(Dependencies.compose)
    debugImplementation(Dependencies.composeDebugPreview)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.material)
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerCompiler)
    implementation(Dependencies.navigation)

    implementation(Dependencies.barcodeAnalyzer)

    val camerax_version = "1.2.3"
    implementation("androidx.camera:camera-core:${camerax_version}")
    implementation("androidx.camera:camera-camera2:${camerax_version}")
    implementation("androidx.camera:camera-lifecycle:${camerax_version}")
    implementation("androidx.camera:camera-view:1.2.3")
    implementation("com.google.guava:guava:30.1-jre")
    //Camera Permission
    implementation("com.google.accompanist:accompanist-permissions:0.19.0")
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}