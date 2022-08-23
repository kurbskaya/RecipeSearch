package com.project.giniatovia.core.network.models

import com.google.gson.annotations.SerializedName

data class RecipeCore(
    @SerializedName("extendedIngredients") val extendedIngredients: List<ExtendedIngredients> = listOf(),
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("summary") val summary: String? = null,
    @SerializedName("instructions") val instructions: String? = null,
    @SerializedName("analyzedInstructions") val analyzedInstructions: List<AnalyzedInstructions> = listOf(),
    @SerializedName("missedIngredientCount") val missedIngredientCount: Int? = null,
    @SerializedName("usedIngredientCount") val usedIngredientCount: Int? = null,
    @SerializedName("calories") val calories: String? = null,
    @SerializedName("servings") val servings: Int? = null,
    @SerializedName("readyInMinutes") val readyInMinutes: Int? = null,
)