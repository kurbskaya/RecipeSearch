package com.project.giniatovia.core.network.api

import com.project.giniatovia.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

interface ProvideInterceptor {

    fun interceptor(): HttpLoggingInterceptor

    fun headerInterceptor() : Interceptor

    abstract class Abstract(
        private val loggingLevel: HttpLoggingInterceptor.Level
    ) : ProvideInterceptor {

        override fun interceptor() = HttpLoggingInterceptor().apply {
            level = loggingLevel
        }

        override fun headerInterceptor(): Interceptor {
            return Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("x-api-key", BuildConfig.API_KEY)
                chain.proceed(builder.build())
            }
        }
    }
}