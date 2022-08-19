package com.project.giniatovia.feature_recipe.presentation.adapters

import com.project.giniatovia.domain.models.Recipe

class RecipeClickListener (val recipeClick: (item: String) -> Unit){
    fun onrRecipeClick(item:String) = recipeClick(item)
}