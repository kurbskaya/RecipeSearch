package com.erya.recipesearch.network.models

import com.google.gson.annotations.SerializedName

data class RecipesList(
    @SerializedName("recipes") val recipes: ArrayList<Recipe> = arrayListOf()
)