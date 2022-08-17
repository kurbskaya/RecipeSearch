package com.project.giniatovia.core.network.implementation

import com.project.giniatovia.core.network.api.MakeService
import com.project.giniatovia.core.network.api.ProvideRecipesService
import com.project.giniatovia.core.network.api.ProvideRetrofit
import com.project.giniatovia.core.network.api.RecipesApi

class RecipeApiImpl(
    retrofitBuilder: ProvideRetrofit,
) : MakeService.Abstract(
    retrofitBuilder
), ProvideRecipesService {

    override fun recipesService() = service(RecipesApi::class.java)
}