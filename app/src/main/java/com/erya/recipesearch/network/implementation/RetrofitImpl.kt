package com.erya.recipesearch.network.implementation

import com.erya.recipesearch.network.api.ProvideConverterFactory
import com.erya.recipesearch.network.api.ProvideOkHttpClientBuilder
import com.erya.recipesearch.network.api.ProvideRetrofit

class RetrofitImpl(
    provideConverterFactory: ProvideConverterFactory,
    httpClientBuilder: ProvideOkHttpClientBuilder,
) : ProvideRetrofit.Abstract(provideConverterFactory, httpClientBuilder)

