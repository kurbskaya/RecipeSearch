package com.project.giniatovia.feature_fridge.presentation

import androidx.recyclerview.widget.DiffUtil
import com.project.giniatovia.feature_recipe.presentation.models.Product

class ProductDiffCallback(
    private val oldList: List<Product>,
    private val newList: List<Product>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldString = oldList[oldItemPosition]
        val newString = newList[newItemPosition]
        return oldString.id == newString.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldString = oldList[oldItemPosition]
        val newString = newList[newItemPosition]
        return oldString.name == newString.name
    }
}
