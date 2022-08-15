package com.erya.recipesearch

class ProductClickListener (val deleteClick: (count: Int) -> Unit){
    fun onDeleteClick(count: Int) = deleteClick(count)
}