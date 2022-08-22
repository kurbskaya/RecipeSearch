package com.project.giniatovia.core.db.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.giniatovia.core.db.models.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM saved_products ORDER BY name ASC")
    suspend fun getSavedProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: ProductEntity)

    @Query("DELETE FROM saved_products")
    suspend fun deleteAllRecords()
}