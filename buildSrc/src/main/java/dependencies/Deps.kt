package dependencies

object Deps {

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.10.1"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
        const val lifecycleCompose = "androidx.lifecycle:lifecycle-runtime-compose:2.6.1"
        const val compose_activity = "androidx.activity:activity-compose:1.7.2"
        const val compose_navigation = "androidx.navigation:navigation-compose:2.6.0"
    }

    object Compose {
        const val platform = "androidx.compose:compose-bom:2023.03.00"
        const val ui = "androidx.compose.ui:ui"
        const val graphics = "androidx.compose.ui:ui-graphics"
        const val preview = "androidx.compose.ui:ui-tooling-preview"
        const val material3 = "androidx.compose.material3:material3"

        const val jUnit4 = "androidx.compose.ui:ui-test-junit4"
        const val testUiTooling = "androidx.compose.ui:ui-tooling"
        const val testUiManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val jUnitExt = "androidx.test.ext:junit:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
        const val mockServer = "com.squareup.okhttp3:mockwebserver:4.11.0"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2"
        const val mockK = "io.mockk:mockk:1.12.5"
    }

    object Hilt {
        const val core = "com.google.dagger:hilt-android:2.44"
        const val compiler = "com.google.dagger:hilt-compiler:2.44"
        const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Glide {
        const val core = "com.github.skydoves:landscapist-glide:2.2.6"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:2.9.0"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val logInterceptor = "com.squareup.okhttp3:logging-interceptor:3.9.0"
    }

    object Room {
        private const val room_version = "2.5.2"
        const val core = "androidx.room:room-runtime:$room_version"
        const val compiler = "androidx.room:room-compiler:$room_version"
        const val ktx = "androidx.room:room-ktx:$room_version"
    }

    object Paging {
        private const val paging_version = "3.1.1"
        const val core = "androidx.paging:paging-runtime:$paging_version"
        const val compose = "androidx.paging:paging-compose:3.2.0"
    }
}