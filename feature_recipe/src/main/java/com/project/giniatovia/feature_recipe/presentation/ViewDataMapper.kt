package com.project.giniatovia.feature_recipe.presentation

import com.project.giniatovia.core.db.models.RecipeEntity
import com.project.giniatovia.feature_recipe.domain.models.ExtendedIngredients
import com.project.giniatovia.feature_recipe.domain.models.RecipeDomain
import com.project.giniatovia.feature_recipe.domain.models.RecipeInstructionDomain
import com.project.giniatovia.feature_recipe.presentation.models.RecipeInfoViewData
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData

object ViewDataMapper {
    fun mapRecipeToViewData(recipes: List<RecipeDomain>) = recipes.map {
        RecipeViewData(
            id = it.id,
            title = it.title,
            image = it.image,
        )
    }

    fun mapRecipeInfoToViewData(recipe: RecipeInstructionDomain): RecipeInfoViewData {
        val instructionsBySteps = mutableListOf<String>()
        recipe.analyzedInstructions.forEach {
            it.steps.map { step ->
                instructionsBySteps.add(step.step!!)
            }
        }
        return RecipeInfoViewData(
            extendedIngredients = recipe.extendedIngredients.map {
                ExtendedIngredients(
                    it.id,
                    it.image,
                    it.name
                )
            },
            id = recipe.id,
            title = recipe.title,
            image = recipe.image,
            summary = recipe.summary,
            instructions = recipe.instructions,
            analyzedInstructions = instructionsBySteps
        )
    }

    fun mapRecipeEntityToViewData(recipe: RecipeEntity) =
        RecipeViewData(
            id = recipe.id,
            title = recipe.title,
            image = recipe.image,
            summary = recipe.summary,
            instructions = recipe.instructions
        )

    fun mapInfoViewDataToRecipeEntity(recipe: RecipeInfoViewData): RecipeEntity =
        RecipeEntity(
            id = recipe.id ?: 0,
            title = recipe.title,
            image = recipe.image,
            summary = recipe.summary,
            instructions = recipe.instructions
        )
}