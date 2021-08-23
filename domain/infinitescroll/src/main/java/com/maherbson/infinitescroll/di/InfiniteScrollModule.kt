package com.maherbson.infinitescroll.di

import com.maherbson.infinitescroll.InfiniteScrollUseCase
import com.maherbson.infinitescroll.InfiniteScrollUseCaseContract
import org.koin.core.module.Module
import org.koin.dsl.module

object InfiniteScrollModule {

    fun load(): List<Module> {
        return listOf(
            module {
                factory<InfiniteScrollUseCaseContract> { InfiniteScrollUseCase() }
            }
        )
    }

}