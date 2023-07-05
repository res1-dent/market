
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ru.hometech.core_common"
    compileSdk = 33


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
    implementation(Dependencies.navigation)
}