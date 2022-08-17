package com.project.giniatovia.presentation

import androidx.recyclerview.widget.DiffUtil
import com.project.giniatovia.presentation.models.Product

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return (oldItem.name == newItem.name
                && oldItem.image == newItem.image
                && oldItem.energy == newItem.energy)
    }
}
