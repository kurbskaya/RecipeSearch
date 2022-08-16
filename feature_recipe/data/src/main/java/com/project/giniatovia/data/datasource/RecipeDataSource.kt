package com.project.giniatovia.data.datasource

import com.erya.recipesearch.network.api.RecipesApi
import com.project.giniatovia.data.mapper.RecipesResponseMapper
import com.project.giniatovia.domain.models.RecipesList
import io.reactivex.rxjava3.core.Single

class RecipeDataSource(
    private val api: RecipesApi,
    private val mapper: RecipesResponseMapper
) {
    fun getRandomRecipe(): Single<RecipesList> {
        return api.getRandomRecipe().map { data -> mapper.map(data) }
    }
}