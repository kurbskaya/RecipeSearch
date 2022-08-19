package com.project.giniatovia.feature_recipe.domain.repository

import com.project.giniatovia.domain.models.RecipesList
import io.reactivex.rxjava3.core.Single


interface RecipesRepository {
    fun getRandomRecipe(): Single<RecipesList>
    fun getRecipeByIngredients(query: String): Single<RecipesList>
}