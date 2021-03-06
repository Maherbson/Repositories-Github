package com.maherbson.repositoriesgithub

import android.app.Application
import com.maherbson.infinitescroll.di.InfiniteScrollModule
import com.maherbson.network.BuildConfig
import com.maherbson.network.di.InterceptorModule
import com.maherbson.network.di.NetworkModule
import com.maherbson.network.di.PROPERTY_BASE_URL
import com.maherbson.repositoriesgithub.features.repositories.di.RepositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RepositoriesGitHubApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        loadModulesKoin()
    }

    private fun loadModulesKoin() {
        startKoin {
            androidContext(this@RepositoriesGitHubApplication)
            modules(
                InterceptorModule.load() +
                        NetworkModule.networkLoad() +
                        InfiniteScrollModule.load() +
                        RepositoriesModule.load()
            )
            properties(mapOf(PROPERTY_BASE_URL to BuildConfig.API_URL))
        }
    }

}