package com.erya.recipesearch.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erya.recipesearch.models.PageRepository

class OnboardingViewModelFactory (
    private val repository: PageRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(OmboardingViewModel::class.java))
            OmboardingViewModel(repository) as T
        else
            throw IllegalArgumentException("ViewModel $modelClass Not Found")
    }
}