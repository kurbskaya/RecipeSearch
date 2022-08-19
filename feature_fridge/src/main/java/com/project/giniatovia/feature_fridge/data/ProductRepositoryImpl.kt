package com.project.giniatovia.feature_fridge.data

import android.content.Context
import com.project.giniatovia.core.network.data.parse
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductRepositoryImpl(private val context: Context) : ProductRepository {
    override fun getAllProducts(): Single<Map<String,Int>> = Single
        .fromCallable { context.parse("ingredients.csv") }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
