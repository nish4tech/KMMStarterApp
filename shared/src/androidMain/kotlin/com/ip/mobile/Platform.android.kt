package com.ip.mobile

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.logging.HttpLoggingInterceptor

actual val httpEngine: HttpClientEngine by lazy {
    OkHttp.create {
        val networkInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        addNetworkInterceptor(networkInterceptor)
        //addInterceptor() todo we can add our Interceptor here
    }
}