package com.erya.recipesearch.domain.model

data class Recipe (
    val image: String,
    val instructions: String,
    val readyInMinutes: Int,
    val servings: Int,
    val summary: String,
    val title: String,
)