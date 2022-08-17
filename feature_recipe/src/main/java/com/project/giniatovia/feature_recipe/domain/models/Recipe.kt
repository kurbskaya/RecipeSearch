package com.project.giniatovia.domain.models

data class Recipe(
    val extendedIngredients: List<ExtendedIngredients> = listOf(),
    val id: Int? = null,
    val title: String? = null,
    val image: String? = null,
    val summary: String? = null,
    val instructions: String? = null,
    val analyzedInstructions: List<AnalyzedInstructions> = listOf(),
)