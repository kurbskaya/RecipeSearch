package com.project.giniatovia.core_network_api.models

import com.google.gson.annotations.SerializedName

data class RecipesList(
    @SerializedName("recipes") val recipes: ArrayList<Recipe> = arrayListOf()
)