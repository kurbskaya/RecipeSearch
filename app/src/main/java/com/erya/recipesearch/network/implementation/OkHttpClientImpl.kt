package com.erya.recipesearch.network.implementation

import com.erya.recipesearch.network.api.ProvideInterceptor
import com.erya.recipesearch.network.api.ProvideOkHttpClientBuilder

class OkHttpClientImpl (
    provideInterceptor: ProvideInterceptor,
) : ProvideOkHttpClientBuilder.Abstract(provideInterceptor)