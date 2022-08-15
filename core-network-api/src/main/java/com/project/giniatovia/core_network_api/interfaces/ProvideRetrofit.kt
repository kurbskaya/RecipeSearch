package com.project.giniatovia.core_network_api.interfaces

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

interface ProvideRetrofit {

    fun provideRetrofit(): Retrofit

    abstract class Abstract(
        private val provideConverterFactory: ProvideConverterFactory,
        private val httpClientBuilder: ProvideOkHttpClientBuilder,
    ) : ProvideRetrofit {

        override fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .addConverterFactory(provideConverterFactory.converterFactory())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(httpClientBuilder.httpClientBuilder().build())
            .baseUrl(BASE_URL)
            .build()
    }

    class Base(
        provideConverterFactory: ProvideConverterFactory,
        httpClientBuilder: ProvideOkHttpClientBuilder,
    ) : Abstract(
        provideConverterFactory,
        httpClientBuilder
    )

    private companion object {
        const val BASE_URL = "https://api.spoonacular.com/"
    }
}