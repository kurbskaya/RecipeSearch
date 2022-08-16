package com.erya.recipesearch.network.api

import com.erya.recipesearch.network.models.RecipesList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RecipesApi {
    @GET("recipes/random")
    fun getRandomRecipe() : Single<RecipesList>
}