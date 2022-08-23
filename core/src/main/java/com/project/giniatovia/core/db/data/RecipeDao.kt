package com.project.giniatovia.core.db.data

import androidx.room.*
import com.project.giniatovia.core.db.models.ProductEntity
import com.project.giniatovia.core.db.models.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM saved_recipes ORDER BY title ASC")
    suspend fun getSavedRecipes(): List<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: RecipeEntity)

    @Query("DELETE FROM saved_recipes")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(recipe: RecipeEntity)

    @Query("SELECT EXISTS (SELECT 1 FROM saved_recipes WHERE id = :recipeId)")
    suspend fun search(recipeId: Int): Boolean

    @Query("SELECT * FROM saved_products ORDER BY name ASC")
    suspend fun getSavedProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: ProductEntity)

    @Query("DELETE FROM saved_products")
    suspend fun deleteAllRecords()

    @Delete
    suspend fun deleteProduct(product: ProductEntity)
}