package com.maherbson.infinityscroll.di

import com.maherbson.infinityscroll.InfiniteScrollUseCase
import com.maherbson.infinityscroll.InfiniteScrollUseCaseContract
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