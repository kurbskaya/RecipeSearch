package com.erya.recipesearch

import android.app.Application
import com.project.giniatovia.core.db.data.RecipeRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RecipesApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { RecipeRoomDatabase.getDatabase(this, applicationScope) }
}