package com.project.giniatovia.feature_fridge.data

import android.content.Context
import com.project.giniatovia.core.network.data.CSVParser
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductRepositoryImpl(private val context: Context) : ProductRepository {
    override fun getAllProducts(): Single<List<String>> = Single
        .fromCallable { CSVParser(context, "ingredients.csv").parse() }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}