package com.project.giniatovia.feature_fridge.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import com.project.giniatovia.feature_fridge.presentation.models.Product
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ProductViewModel(
    private val repository: ProductRepository
):ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _productLiveData = MutableLiveData<ArrayList<Product>>()
    val productLiveData: LiveData<ArrayList<Product>> = _productLiveData

    fun add(product: Product) {
        val oldList = _productLiveData.value
        if (oldList == null){
            _productLiveData.value = arrayListOf(product)
            return
        }
        val tmp = ArrayList<Product>(oldList)
        tmp.add(product)
        _productLiveData.value = tmp
    }

    fun getAllProducts() {// TODO: положить в общий список продуктов 
//        val disposable = repository.getAllProducts().subscribe({ parsedResult ->
//            val allIngredients = arrayListOf<String>()
//            parsedResult.forEach { entry -> allIngredients.add(entry.key) }
//            _productLiveData.postValue(parsedResult)
//        }, {
//            it.toString()
//        })
//        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}