package com.project.giniatovia.core_network_api.interfaces

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

interface ProvideConverterFactory {

    fun converterFactory(): Converter.Factory

    class Base : ProvideConverterFactory {

        override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
    }
}