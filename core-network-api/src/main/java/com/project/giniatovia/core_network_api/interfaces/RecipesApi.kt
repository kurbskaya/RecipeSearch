package com.project.giniatovia.core_network_api.interfaces

import com.project.giniatovia.core_network_api.models.RecipesList
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET

interface RecipesApi {
    @GET("recipes/random")
    fun getRandomRecipe() : Single<RecipesList>
}