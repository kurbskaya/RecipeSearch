package com.project.giniatovia.core.network.implementation

import com.project.giniatovia.core.network.api.ProvideInterceptor
import com.project.giniatovia.core.network.api.ProvideOkHttpClientBuilder

class OkHttpClientImpl (
    provideInterceptor: ProvideInterceptor,
) : ProvideOkHttpClientBuilder.Abstract(provideInterceptor)