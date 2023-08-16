import dependencies.Config
import dependencies.Deps

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

val buildString = { k: String -> "\"${k}\"" }

android {
    namespace = "com.hiroshisasmita.videogamesapp"
    compileSdk = Config.androidCompileSdkVersion

    defaultConfig {
        applicationId = "com.hiroshisasmita.videogamesapp"
        minSdk = Config.androidMinSdkVersion
        targetSdk = Config.androidTargetSdkVersion
        versionCode = Config.applicationVersionCode
        versionName = Config.applicationVersionName

        val apiKey = "39b0b2e635384d158f3b6fdd62f87b7d"

        resValue("string", "app_name", buildString(Config.appName))
        buildConfigField("String", "API_KEY", buildString(apiKey))

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
        buildConfig = true
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
    implementation(Deps.Hilt.compose)
    kapt(Deps.Hilt.compiler)

    implementation(Deps.Glide.core)

    implementation(Deps.Retrofit.core)
    implementation(Deps.Retrofit.gsonConverter)
    implementation(Deps.Retrofit.logInterceptor)

    implementation(Deps.Room.core)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.ktx)

    implementation(Deps.Paging.core)
    implementation(Deps.Paging.compose)

    implementation(Deps.AndroidX.lifecycleCompose)

    testImplementation(Deps.Test.mockServer)
    testImplementation(Deps.Test.coroutine)
    testImplementation(Deps.Test.mockK)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
