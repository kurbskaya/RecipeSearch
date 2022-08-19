package com.project.giniatovia.feature_fridge.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ProductViewModel(
    private val repository: ProductRepository
):ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _productLiveData = MutableLiveData<Map<String, Int>>()
    val productLiveData: LiveData<Map<String, Int>> = _productLiveData

    fun getAllProducts() {
        val disposable = repository.getAllProducts().subscribe({ parsedResult ->
            val allIngredients = arrayListOf<String>()
            parsedResult.forEach { entry -> allIngredients.add(entry.key) }
            _productLiveData.postValue(parsedResult)
        }, {
            it.toString()
        })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}