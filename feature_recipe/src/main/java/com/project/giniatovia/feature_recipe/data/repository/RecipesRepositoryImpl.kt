package com.project.giniatovia.feature_recipe.data.repository

import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.domain.models.RecipesList
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import io.reactivex.rxjava3.core.Single


class RecipesRepositoryImpl(
    private val dataSource: RecipeDataSource
) : RecipesRepository {

    override fun getRandomRecipe(): Single<RecipesList> {
        return dataSource.getRandomRecipe()
    }

    override fun getRecipeByIngredients(query: String): Single<RecipesList> {
        return dataSource.getRecipeByIngredients(query)
    }
}
