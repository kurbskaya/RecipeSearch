package com.project.giniatovia.feature_fridge.presentation

import com.project.giniatovia.core.db.models.ProductEntity
import com.project.giniatovia.core.network.models.Product

object ProductMapper {
    fun mapProductToEntity(newProduct: Product) =
        ProductEntity(
            id = newProduct.name,
            name = newProduct.name,
            image = newProduct.image
        )

    fun mapEntityToProduct(productEntity: ProductEntity) =
        Product(
            id = productEntity.name,
            name = productEntity.name,
            image = productEntity.image
        )
}