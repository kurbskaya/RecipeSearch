package com.erya.recipesearch.network.implementation

import com.erya.recipesearch.network.api.MakeService
import com.erya.recipesearch.network.api.ProvideRecipesService
import com.erya.recipesearch.network.api.ProvideRetrofit
import com.erya.recipesearch.network.api.RecipesApi

class RecipeApiImpl(
    retrofitBuilder: ProvideRetrofit,
) : MakeService.Abstract(
    retrofitBuilder
), ProvideRecipesService {

    override fun recipesService() = service(RecipesApi::class.java)
}