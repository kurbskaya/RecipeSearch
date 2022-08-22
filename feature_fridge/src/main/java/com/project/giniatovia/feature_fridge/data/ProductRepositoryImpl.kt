package com.project.giniatovia.feature_fridge.data

import android.content.Context
import androidx.annotation.WorkerThread
import com.project.giniatovia.core.db.data.ProductDao
import com.project.giniatovia.core.db.models.ProductEntity
import com.project.giniatovia.core.network.data.CSVParser
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductRepositoryImpl(
    private val context: Context,
    private val productDao: ProductDao
    ) : ProductRepository {
    override fun getAllProducts(): Single<List<String>> = Single
        .fromCallable { CSVParser(context, "ingredients.csv").parse() }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insertProduct(recipe: ProductEntity) = productDao.insertProduct(recipe)

    override suspend fun getSavedProducts(): List<ProductEntity> = productDao.getSavedProducts()
}