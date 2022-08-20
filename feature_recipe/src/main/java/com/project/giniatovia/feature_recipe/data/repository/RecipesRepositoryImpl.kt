package com.project.giniatovia.feature_recipe.data.repository

import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository

class RecipesRepositoryImpl(
    private val dataSource: RecipeDataSource
) : RecipesRepository {

    override suspend fun getRandomRecipe() = dataSource.getRandomRecipe()

    override suspend fun getRecipeByIngredients(query: String) = dataSource.getRecipeByIngredients(query)

    override suspend fun getRecipeInfoById(id: Int) = dataSource.getRecipeInfoByIdData(id)
}
