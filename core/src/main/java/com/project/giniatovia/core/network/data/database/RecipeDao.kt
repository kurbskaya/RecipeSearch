package com.erya.recipesearch.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM saved_recipes ORDER BY title ASC")
    fun getSavedRecipes(): Flow<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: RecipeEntity)

    @Query("DELETE FROM saved_recipes")
    suspend fun deleteAll()
}