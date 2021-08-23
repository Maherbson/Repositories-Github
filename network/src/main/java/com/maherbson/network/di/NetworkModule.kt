package com.maherbson.network.di

import com.maherbson.network.BuildConfig
import com.maherbson.network.client.Client
import com.maherbson.network.info.NetworkConnection
import com.maherbson.network.info.NetworkConnectionContract
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 30L
private const val READ_TIMEOUT = 30L
const val PROPERTY_BASE_URL = "PROPERTY_BASE_URL"

object NetworkModule {

    fun networkLoad(): List<Module> = listOf(module {
        factory<NetworkConnectionContract> {
            NetworkConnection(
                context = get()
            )
        }

        factory {
            Retrofit
                .Builder()
                //.baseUrl(BuildConfig.API_URL)
                .baseUrl(getProperty(PROPERTY_BASE_URL))
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        factory {
            val interceptor: List<Interceptor> = get(RetrofitInterceptorQualifier)

            OkHttpClient()
                .newBuilder()
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .interceptors(interceptor)
                .build()
        }

        factory {
            Client(retrofit = get())
        }
    })

    private fun OkHttpClient.Builder.interceptors(
        interceptors: List<Interceptor>
    ): OkHttpClient.Builder {
        interceptors.forEach { interceptor ->
            this.addInterceptor(interceptor)
        }
        return this
    }
}
