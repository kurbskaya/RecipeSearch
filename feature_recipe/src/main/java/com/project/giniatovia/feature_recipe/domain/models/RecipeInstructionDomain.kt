package com.project.giniatovia.feature_recipe.domain.models

import com.project.giniatovia.core.network.models.AnalyzedInstructions
import com.project.giniatovia.core.network.models.ExtendedIngredients

class RecipeInstructionDomain(
    val extendedIngredients: List<ExtendedIngredients> = listOf(),
    val id: Int? = null,
    val title: String? = null,
    val image: String? = null,
    val summary: String? = null,
    val instructions: String? = null,
    val analyzedInstructions: List<AnalyzedInstructions> = listOf(),
)

data class AnalyzedInstructions(
    val name: String? = null,
    val steps: List<Step> = listOf()
)

data class ExtendedIngredients(
    val id: Int? = null,
    val image: String? = null,
    val name: String? = null,
)

data class Step(
    val number: Int? = null,
    val step: String? = null,
)
