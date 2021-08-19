object KotlinLibs {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradle}"
    const val ktLint = "org.jlleitschuh.gradle.ktlint"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutinesLifecycle}"
    const val coroutinesRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutinesLifecycle}"
    const val coroutinesLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.coroutinesLifecycle}"
}
