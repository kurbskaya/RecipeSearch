package com.project.giniatovia.feature_fridge.domain

import io.reactivex.rxjava3.core.Single

interface ProductRepository {
    fun getAllProducts() : Single<List<String>>
}