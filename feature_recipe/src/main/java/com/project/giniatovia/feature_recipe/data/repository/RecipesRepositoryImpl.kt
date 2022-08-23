package com.project.giniatovia.feature_recipe.data.repository

import androidx.annotation.WorkerThread
import com.project.giniatovia.core.db.data.RecipeDao
import com.project.giniatovia.core.db.models.RecipeEntity
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import kotlinx.coroutines.flow.Flow

class RecipesRepositoryImpl(
    private val dataSource: RecipeDataSource,
    private val dao: RecipeDao
) : RecipesRepository {

    override suspend fun getRandomRecipe() = dataSource.getRandomRecipe()

    override suspend fun getRecipeByIngredients(query: String) = dataSource.getRecipeByIngredients(query)

    override suspend fun getRecipeInfoById(id: Int) = dataSource.getRecipeInfoByIdData(id)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insertRecipe(recipe: RecipeEntity) = dao.insert(recipe)

    override suspend fun getSavedRecipes(): List<RecipeEntity> = dao.getSavedRecipes()

    @WorkerThread
    override suspend fun deleteRecipe(recipe: RecipeEntity) = dao.delete(recipe)

    @WorkerThread
    override suspend fun searchRecipe(recipeId: Int) = dao.search(recipeId)

    override suspend fun getRecipeInfoNutrition(id: Int) = dataSource.getRecipeInfoNutrition(id)
}
