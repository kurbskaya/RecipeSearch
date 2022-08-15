package com.project.giniatovia.core_network_api.interfaces

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
                builder.header("x-api-key", API_KEY)
                chain.proceed(builder.build())
            }
        }
    }

    companion object {
        const val API_KEY = "ed38ab470ce64bc7a1906a082c583f2c"
    }

    class Debug : Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : Abstract(HttpLoggingInterceptor.Level.NONE)
}