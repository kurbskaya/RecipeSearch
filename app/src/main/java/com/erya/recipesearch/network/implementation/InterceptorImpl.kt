package com.erya.recipesearch.network.implementation

import com.erya.recipesearch.network.api.ProvideInterceptor
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorImpl(loggingLevel: HttpLoggingInterceptor.Level)
    : ProvideInterceptor.Abstract(loggingLevel) {
    class Debug : ProvideInterceptor.Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : ProvideInterceptor.Abstract(HttpLoggingInterceptor.Level.NONE)
}