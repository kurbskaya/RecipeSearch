package com.erya.recipesearch.network.models

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("extendedIngredients") val extendedIngredients: List<ExtendedIngredients> = listOf(),
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("summary") val summary: String? = null,
    @SerializedName("instructions") val instructions: String? = null,
    @SerializedName("analyzedInstructions") val analyzedInstructions: List<AnalyzedInstructions> = listOf(),
)