package com.project.giniatovia.core.network.implementation

import com.project.giniatovia.core.network.api.ProvideConverterFactory
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class ConverterFactoryImpl: ProvideConverterFactory {

    override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
}