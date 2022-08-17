package com.project.giniatovia.core.network.api

import retrofit2.Converter

interface ProvideConverterFactory {

    fun converterFactory(): Converter.Factory
}