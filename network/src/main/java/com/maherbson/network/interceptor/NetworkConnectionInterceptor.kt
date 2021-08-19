package com.maherbson.network.interceptor

import com.maherbson.network.exception.NetworkException
import com.maherbson.network.info.NetworkConnectionContract
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    private val networkConnectionContract: NetworkConnectionContract
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (networkConnectionContract.hasInternetConnection().not()) {
            throw NetworkException()
        }
        val requestBuilder = chain.request().newBuilder()
        return chain.proceed(requestBuilder.build())
    }
}
