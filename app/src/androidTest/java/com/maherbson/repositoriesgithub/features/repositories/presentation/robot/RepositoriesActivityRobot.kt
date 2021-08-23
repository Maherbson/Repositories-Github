package com.maherbson.repositoriesgithub.features.repositories.presentation.robot

import com.maherbson.androidtest.rule.ActivityTest
import com.maherbson.infinitescroll.di.InfiniteScrollModule
import com.maherbson.network.di.InterceptorModule
import com.maherbson.network.di.NetworkModule
import com.maherbson.repositoriesgithub.features.repositories.di.RepositoriesModule
import com.maherbson.repositoriesgithub.features.repositories.presentation.RepositoriesActivity
import org.koin.core.module.Module

open class RepositoriesActivityRobot :
    ActivityTest<RepositoriesAssertionRobot, RepositoriesActionRobot>(
        RepositoriesActivity::class.java
    ) {

    override fun getModules(): List<Module> {
        return InterceptorModule.load() +
                NetworkModule.networkLoad() +
                InfiniteScrollModule.load() +
                RepositoriesModule.load()
    }
}