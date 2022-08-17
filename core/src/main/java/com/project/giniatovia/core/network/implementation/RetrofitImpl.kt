package com.project.giniatovia.core.network.implementation

import com.project.giniatovia.core.network.api.ProvideConverterFactory
import com.project.giniatovia.core.network.api.ProvideOkHttpClientBuilder
import com.project.giniatovia.core.network.api.ProvideRetrofit

class RetrofitImpl(
    provideConverterFactory: ProvideConverterFactory,
    httpClientBuilder: ProvideOkHttpClientBuilder,
) : ProvideRetrofit.Abstract(provideConverterFactory, httpClientBuilder)

