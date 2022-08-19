package com.project.giniatovia.feature_fridge.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.giniatovia.core.network.models.Product
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _productLiveData = MutableLiveData<List<Product>>()
    val productLiveData: LiveData<List<Product>> = _productLiveData

    fun getAllProducts() {
        val disposable = repository.getAllProducts().subscribe({ parsedResult ->
            _productLiveData.postValue(parsedResult.map { name ->
                Product(name = name, image = IMAGE_URL + name.lowercase().replace(" ", "-") + FORMAT)
            })
        }, {
            it.toString()
        })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    companion object {
        private const val IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"
        private const val FORMAT = ".jpg"
    }
}