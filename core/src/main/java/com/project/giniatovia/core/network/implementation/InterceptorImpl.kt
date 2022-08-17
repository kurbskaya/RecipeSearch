package com.project.giniatovia.core.network.implementation

import com.project.giniatovia.core.network.api.ProvideInterceptor
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorImpl(loggingLevel: HttpLoggingInterceptor.Level)
    : ProvideInterceptor.Abstract(loggingLevel) {
    class Debug : ProvideInterceptor.Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : ProvideInterceptor.Abstract(HttpLoggingInterceptor.Level.NONE)
}