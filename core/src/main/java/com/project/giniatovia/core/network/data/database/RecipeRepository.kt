package com.erya.recipesearch.data.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class RecipeRepository(private val dao: RecipeDao) {
    val savedRecipes: Flow<List<RecipeEntity>> = dao.getSavedRecipes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(recipe: RecipeEntity) {
        dao.insert(recipe)
    }
}