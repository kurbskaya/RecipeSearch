package com.project.giniatovia.core_network_impl

import com.project.giniatovia.core_network_api.interfaces.*

class NetworkModule {
    fun provideRecipesApi(): RecipesApi {
        return ProvideRecipesService.Base(ProvideRetrofit.Base(
            ProvideConverterFactory.Base(),
            ProvideOkHttpClientBuilder.Base(
                if (BuildConfig.DEBUG)
                    ProvideInterceptor.Debug()
                else
                    ProvideInterceptor.Release()
            )
        )).recipesService()
    }
}