package com.project.giniatovia.feature_recipe.data.datasource

import com.project.giniatovia.core.network.api.RecipesApi
import com.project.giniatovia.feature_recipe.domain.models.*

class RecipeDataSource(private val api: RecipesApi) {
    suspend fun getRandomRecipe() = RecipesListDomain(
        recipes = api.getRandomRecipe().recipes.map {
            RecipeDomain(
                it.id,
                it.title,
                it.image,
                it.summary
            )
        }
    )

    suspend fun getRecipeByIngredients(query: String) = api.getRecipeByIngredients(query).map {
        RecipeDomain(
            it.id,
            it.title,
            it.image,
            it.summary,
            it.missedIngredientCount,
            it.usedIngredientCount
        )
    }

    suspend fun getRecipeInfoByIdData(id: Int): RecipeInstructionDomain {
        val response = api.getRecipeInfoByIdData(id)
        return RecipeInstructionDomain(
            extendedIngredients = response.extendedIngredients,
            id = response.id,
            title = response.title,
            image = response.image,
            summary = response.summary,
            instructions = response.instructions,
            analyzedInstructions = response.analyzedInstructions,
            servings = response.servings,
            readyInMinutes = response.readyInMinutes
        )
    }

    suspend fun getRecipeInfoNutrition(id: Int): RecipeNutritionDomain {
        val response = api.getRecipeInfoNutrition(id)
        return RecipeNutritionDomain(
            id = response.id,
            calories = response.calories
        )
    }

    suspend fun getProductImage(product: String): ProductDomain {
        with (api.getProductImage(product).results.first()) {
            return ProductDomain(
                id = id,
                name = name,
                image = image
            )
        }
    }
}