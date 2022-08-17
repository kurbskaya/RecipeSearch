package com.project.giniatovia.data.repository

import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.domain.models.RecipesList
import com.project.giniatovia.domain.repository.RecipesRepository
import io.reactivex.rxjava3.core.Single


class RecipesRepositoryImpl(
    private val dataSource: RecipeDataSource
) : RecipesRepository {

    override fun getRandomRecipe(): Single<RecipesList> {
        return dataSource.getRandomRecipe()
    }
}
