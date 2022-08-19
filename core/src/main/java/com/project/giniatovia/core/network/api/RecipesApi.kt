package com.project.giniatovia.core.network.api

import com.project.giniatovia.core.network.models.ExtendedIngredients
import com.project.giniatovia.core.network.models.RecipesList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesApi {
    @GET("recipes/random")
    fun getRandomRecipe() : Single<RecipesList>

    @GET("recipes/findByIngredients")
    fun getRecipeByIngredients(@Query("ingredients") ingredients: String) : Single<RecipesList>
}