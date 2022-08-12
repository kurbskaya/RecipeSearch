package com.erya.recipesearch.domain.repository

import com.erya.recipesearch.domain.model.Recipe
import io.reactivex.rxjava3.core.Single

interface RecipesRepository {
    fun getRandomRecipe(): Single<Recipe>
}