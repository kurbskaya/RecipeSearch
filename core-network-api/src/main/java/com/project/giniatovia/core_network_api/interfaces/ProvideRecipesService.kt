package com.project.giniatovia.core_network_api.interfaces

interface ProvideRecipesService {
    fun recipesService(): RecipesApi

    class Base(
        retrofitBuilder: ProvideRetrofit,
    ) : MakeService.Abstract(
        retrofitBuilder
    ), ProvideRecipesService {

        override fun recipesService() = service(RecipesApi::class.java)
    }
}