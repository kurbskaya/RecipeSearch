package com.erya.recipesearch.network.implementation

import com.erya.recipesearch.network.api.ProvideConverterFactory
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class ConverterFactoryImpl: ProvideConverterFactory {

    override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
}