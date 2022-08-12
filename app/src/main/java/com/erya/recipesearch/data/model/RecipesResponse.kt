package com.erya.recipesearch.data.model

import com.google.gson.annotations.SerializedName

class RecipeResponse(
    @SerializedName("image")
    val image: String,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
)

class RecipesResponse (
    @SerializedName("recipes")
    val recipes: List<RecipeResponse>
)