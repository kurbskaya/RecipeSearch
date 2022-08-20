package com.erya.recipesearch.data.database

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RecipesApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { RecipeRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { RecipeRepository(database.recipeDao()) }
}