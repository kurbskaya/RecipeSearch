package com.project.giniatovia.feature_fridge.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import com.project.giniatovia.core.network.models.Product
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ProductViewModel(
    private val repository: ProductRepository
):ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _productLiveData = MutableLiveData<List<Product>>()
    val productLiveData: LiveData<List<Product>> = _productLiveData

    private val _allProductLiveData = MutableLiveData<List<String>>()
    val allProductLiveData: LiveData<List<String>> = _allProductLiveData

    fun getAllProducts() {
        val disposable = repository.getAllProducts().subscribe({ parsedResult ->
            _allProductLiveData.postValue(parsedResult)
        }, {
            it.toString()
        })
        compositeDisposable.add(disposable)
    }

    fun add(strProduct: String) {
        val oldList = _productLiveData.value
        val newProduct = Product(
            name = strProduct,
            image = IMAGE_URL + strProduct.lowercase().replace(" ", "-") + FORMAT
        )
        if (oldList == null){
            _productLiveData.value = arrayListOf(newProduct)
            return
        }
        val tmp = ArrayList<Product>(oldList)
        tmp.add(newProduct)
        _productLiveData.value = tmp
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