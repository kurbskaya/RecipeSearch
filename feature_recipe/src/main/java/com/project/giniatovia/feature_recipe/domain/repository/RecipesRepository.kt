package com.project.giniatovia.feature_recipe.domain.repository

import com.project.giniatovia.core.db.models.RecipeEntity
import com.project.giniatovia.feature_recipe.domain.models.RecipeDomain
import com.project.giniatovia.feature_recipe.domain.models.RecipeInstructionDomain
import com.project.giniatovia.feature_recipe.domain.models.RecipeNutritionDomain
import com.project.giniatovia.feature_recipe.domain.models.RecipesListDomain
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    suspend fun getRandomRecipe(): RecipesListDomain
    suspend fun getRecipeByIngredients(query: String): List<RecipeDomain>
    suspend fun getRecipeInfoById(id: Int): RecipeInstructionDomain
    suspend fun insertRecipe(recipe: RecipeEntity)
    suspend fun getSavedRecipes() : List<RecipeEntity>
    suspend fun deleteRecipe(recipe: RecipeEntity)
    suspend fun searchRecipe(recipeId: Int): Boolean
    suspend fun getRecipeInfoNutrition(id: Int): RecipeNutritionDomain
}