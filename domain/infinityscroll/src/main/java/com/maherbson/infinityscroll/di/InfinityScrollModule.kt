package com.maherbson.infinityscroll.di

import com.maherbson.infinityscroll.InfinityScroll
import com.maherbson.infinityscroll.InfinityScrollContract
import org.koin.core.module.Module
import org.koin.dsl.module

object InfinityScrollModule {

    fun load(): List<Module> {
        return listOf(
            module {
                factory<InfinityScrollContract> { InfinityScroll() }
            }
        )
    }

}