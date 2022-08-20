package com.project.giniatovia.feature_recipe.presentation.models

import com.project.giniatovia.feature_recipe.domain.models.AnalyzedInstructions
import com.project.giniatovia.feature_recipe.domain.models.ExtendedIngredients

class RecipeInfoViewData(
    val extendedIngredients: List<ExtendedIngredients> = listOf(),
    val id: Int? = null,
    val title: String? = null,
    val image: String? = null,
    val summary: String? = null,
    val instructions: String? = null,
    val analyzedInstructions: List<String> = listOf(),
)