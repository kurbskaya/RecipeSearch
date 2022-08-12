package com.erya.recipesearch.data.api

import com.erya.recipesearch.API_KEY
import com.erya.recipesearch.data.model.RecipesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RecipesApi {
    @GET("recipes/random?apiKey=$API_KEY")
    fun getRandomRecipe() : Single<RecipesResponse>
}