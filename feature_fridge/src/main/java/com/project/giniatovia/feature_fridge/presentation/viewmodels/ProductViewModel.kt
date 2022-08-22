package com.project.giniatovia.feature_fridge.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.giniatovia.feature_fridge.domain.ProductRepository
import com.project.giniatovia.core.network.models.Product
import com.project.giniatovia.feature_fridge.presentation.ProductMapper
import com.project.giniatovia.feature_recipe.presentation.models.UiItemError
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _productLiveData = MutableLiveData<UiItemError<List<Product>>>()
    val productLiveData: LiveData<UiItemError<List<Product>>> = _productLiveData

    private val _allProductLiveData = MutableLiveData<UiItemError<List<String>>>()
    val allProductLiveData: LiveData<UiItemError<List<String>>> = _allProductLiveData

    fun getAllProducts() {
        val disposable = repository.getAllProducts().subscribe({ parsedResult ->
            _allProductLiveData.postValue(UiItemError.Success(parsedResult))
        }, {
            _allProductLiveData.postValue(UiItemError.Error(it))
        })
        compositeDisposable.add(disposable)
    }

    fun getProductsFromDb() {
        viewModelScope.launch {
            runCatching {
                repository.getSavedProducts().map { ProductMapper.mapEntityToProduct(it) }
            }.onSuccess { savedProducts ->
                _productLiveData.value = UiItemError.Success(savedProducts)
            }.onFailure { exception ->
                _productLiveData.value = UiItemError.Error(exception)
            }
        }
    }

    fun add(strProduct: String) {
        if (_productLiveData.value is UiItemError.Success) {
            val oldList = (_productLiveData.value as UiItemError.Success<List<Product>>).elements
            val newProduct = Product(
                name = strProduct,
                image = IMAGE_URL + strProduct.lowercase().replace(" ", "-") + FORMAT
            )
            if (oldList == null){
                _productLiveData.value = UiItemError.Success(arrayListOf(newProduct))
                return
            }
            val tmp = ArrayList<Product>(oldList)
            tmp.add(newProduct)
            _productLiveData.value = UiItemError.Success(tmp)

            viewModelScope.launch {
                repository.insertProduct(
                    ProductMapper.mapProductToEntity(newProduct)
                )
            }
        }
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