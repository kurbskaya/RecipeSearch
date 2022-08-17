package com.project.giniatovia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.giniatovia.domain.repository.RecipesRepository

class ViewModelFactory (
    private val repository: RecipesRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RecipeViewModel::class.java))
            RecipeViewModel(repository) as T
        else
            throw IllegalArgumentException("ViewModel $modelClass Not Found")
    }
}