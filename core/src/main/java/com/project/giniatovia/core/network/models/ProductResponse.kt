package com.project.giniatovia.core.network.models

data class ProductResponse(
    val results: List<Result>,
)

data class Result(
    val id: Int,
    val image: String,
    val name: String
)