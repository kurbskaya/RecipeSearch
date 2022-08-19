package com.erya.recipesearch.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erya.recipesearch.models.Page
import com.erya.recipesearch.models.PageRepository

class OmboardingViewModel(
    private val repository: PageRepository
) : ViewModel() {
    private val _pageLiveData = MutableLiveData<ArrayList<Page>>()
    val pageLiveData: LiveData<ArrayList<Page>> = _pageLiveData

    fun init() {
        val list = ArrayList<Page>(repository.getPages())
        _pageLiveData.value = list
    }
}