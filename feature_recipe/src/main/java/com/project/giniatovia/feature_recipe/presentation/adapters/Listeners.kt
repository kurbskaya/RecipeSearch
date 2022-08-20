package com.project.giniatovia.feature_recipe.presentation.adapters

import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData

class RecipeClickListener (val recipeClick: (item: RecipeViewData) -> Unit){
    fun onRecipeClick(item:RecipeViewData) = recipeClick(item)
}