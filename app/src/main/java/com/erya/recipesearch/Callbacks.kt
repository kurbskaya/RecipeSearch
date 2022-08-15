package com.erya.recipesearch

import androidx.recyclerview.widget.DiffUtil

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return (oldItem.name == newItem.name
                && oldItem.image == newItem.image
                && oldItem.energy == newItem.energy)
    }
}
