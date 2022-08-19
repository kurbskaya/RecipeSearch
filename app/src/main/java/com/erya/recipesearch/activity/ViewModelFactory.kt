package com.erya.recipesearch.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import com.project.giniatovia.feature_fridge.presentation.viewmodels.ProductViewModel
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import com.project.giniatovia.feature_recipe.presentation.viewmodels.RecipeViewModel

class ViewModelFactory (
    private val recipeRepository: RecipesRepository,
    private val productRepository: ProductRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RecipeViewModel::class.java))
            RecipeViewModel(recipeRepository) as T
        else if (modelClass.isAssignableFrom(ProductViewModel::class.java))
            ProductViewModel(productRepository) as T
        else
            throw IllegalArgumentException("ViewModel $modelClass Not Found")
    }
}