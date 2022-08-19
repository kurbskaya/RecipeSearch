package com.project.giniatovia.feature_fridge.presentation

import androidx.recyclerview.widget.DiffUtil
import com.project.giniatovia.feature_fridge.presentation.models.Product

class ProductDiffCallback: DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }
}
