package com.project.giniatovia.core.network.api

import com.project.giniatovia.core.network.models.RecipesList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RecipesApi {
    @GET("recipes/random")
    fun getRandomRecipe() : Single<RecipesList>
}