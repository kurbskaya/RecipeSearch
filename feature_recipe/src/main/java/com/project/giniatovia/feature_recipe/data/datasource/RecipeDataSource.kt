package com.project.giniatovia.feature_recipe.data.datasource

import com.project.giniatovia.core.network.api.RecipesApi
import com.project.giniatovia.feature_recipe.data.mapper.RecipesResponseMapper
import com.project.giniatovia.domain.models.RecipesList
import io.reactivex.rxjava3.core.Single

class RecipeDataSource(
    private val api: RecipesApi,
    private val mapper: RecipesResponseMapper
) {
    fun getRandomRecipe(): Single<RecipesList> {
        return api.getRandomRecipe().map { data -> mapper.map(data) }
    }

    fun getRecipeByIngredients(query: String): Single<RecipesList> {
        return api.getRecipeByIngredients(query).map { data -> mapper.map(data) }
    }
}