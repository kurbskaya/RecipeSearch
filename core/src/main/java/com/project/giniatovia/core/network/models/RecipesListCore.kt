package com.project.giniatovia.core.network.models

import com.google.gson.annotations.SerializedName

class RecipesListCore(
    @SerializedName("recipes") val recipes: List<RecipeCore> = listOf()
)