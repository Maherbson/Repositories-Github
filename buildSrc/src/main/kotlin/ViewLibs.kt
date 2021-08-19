object ViewLibs {
    const val gradle = "com.android.tools.build:gradle:${Versions.buildGradle}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.androidxFragment}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val activity = "androidx.activity:activity-ktx:${Versions.androidxActivity}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationFeaturesModule =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}
