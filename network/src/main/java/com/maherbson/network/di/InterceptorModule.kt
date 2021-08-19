package com.maherbson.network.di

import com.maherbson.network.BuildConfig
import com.maherbson.network.interceptor.NetworkConnectionInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.dsl.module

object RetrofitInterceptorQualifier : Qualifier {
    override val value: QualifierValue
        get() = this::class.java.name
}

object InterceptorModule {
    fun load(): List<Module> = listOf(module {
        single(RetrofitInterceptorQualifier) {
            listOf(
                NetworkConnectionInterceptor(networkConnectionContract = get()),
                getHttpLoggingInterceptor()
            )
        }
    })
}

private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLogInterceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        httpLogInterceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        httpLogInterceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return httpLogInterceptor
}
