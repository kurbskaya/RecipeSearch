package com.project.giniatovia.feature_fridge.domain

import com.project.giniatovia.core.db.models.ProductEntity
import io.reactivex.rxjava3.core.Single

interface ProductRepository {
    fun getAllProducts() : Single<List<String>>
    suspend fun insertProduct(recipe: ProductEntity)
    suspend fun getSavedProducts() : List<ProductEntity>
    suspend fun getProductImage(product: String) : String?
}