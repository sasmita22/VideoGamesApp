import dependencies.Config
import dependencies.Deps

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.hiroshisasmita.videogamesapp"
    compileSdk = Config.androidCompileSdkVersion

    defaultConfig {
        applicationId = "com.hiroshisasmita.videogamesapp"
        minSdk = Config.androidMinSdkVersion
        targetSdk = Config.androidTargetSdkVersion
        versionCode = Config.applicationVersionCode
        versionName = Config.applicationVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Deps.AndroidX.core)
    implementation(Deps.AndroidX.lifecycle)
    implementation(Deps.AndroidX.compose_activity)
    implementation(Deps.AndroidX.compose_navigation)
    implementation(platform(Deps.Compose.platform))
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.graphics)
    implementation(Deps.Compose.preview)
    implementation(Deps.Compose.material3)
    testImplementation(Deps.Test.jUnit)
    androidTestImplementation(Deps.Test.jUnitExt)
    androidTestImplementation(Deps.Test.espresso)
    androidTestImplementation(platform(Deps.Compose.platform))
    androidTestImplementation(Deps.Compose.jUnit4)
    debugImplementation(Deps.Compose.testUiTooling)
    debugImplementation(Deps.Compose.testUiManifest)

    implementation(Deps.Hilt.core)
    kapt(Deps.Hilt.compiler)

    implementation(Deps.Glide.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
