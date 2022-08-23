package com.project.giniatovia.core.network.api

import com.project.giniatovia.core.network.models.Product
import com.project.giniatovia.core.network.models.ProductResponse
import com.project.giniatovia.core.network.models.RecipeCore
import com.project.giniatovia.core.network.models.RecipesListCore
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesApi {
    @GET("recipes/random")
    suspend fun getRandomRecipe() : RecipesListCore

    @GET("recipes/findByIngredients")
    suspend fun getRecipeByIngredients(@Query("ingredients") ingredients: String) : List<RecipeCore>

    @GET("recipes/{id}/information")
    suspend fun getRecipeInfoByIdData(@Path("id") id: Int) : RecipeCore

    @GET("food/ingredients/search")
    suspend fun getProductImage(@Query("query") product: String) : ProductResponse

    @GET("recipes/{id}/nutritionWidget.json")
    suspend fun getRecipeInfoNutrition(@Path("id") id: Int) : RecipeCore
}