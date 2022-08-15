package com.erya.recipesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FridgeViewModel : ViewModel() {
    private var _products = MutableLiveData<MutableList<Product>>()
    var products: LiveData<MutableList<Product>> = _products

    fun getProducts(){
        // TODO:
    }

    fun deleteProduct(productCount: Int) {
        // TODO:  
    }
}