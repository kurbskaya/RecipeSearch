package com.project.giniatovia.feature_fridge.presentation

import androidx.recyclerview.widget.DiffUtil
import com.project.giniatovia.core.network.models.Product

class ProductDiffCallback: DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }
}
