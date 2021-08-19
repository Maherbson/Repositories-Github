package com.maherbson.repositoriesgithub

import android.app.Application
import com.maherbson.infinityscroll.di.InfinityScrollModule
import com.maherbson.network.di.InterceptorModule
import com.maherbson.network.di.NetworkModule
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
                        InfinityScrollModule.load()
            )
        }
    }

}