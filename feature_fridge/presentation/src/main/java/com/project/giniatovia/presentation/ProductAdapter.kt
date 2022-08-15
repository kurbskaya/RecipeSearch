package com.project.giniatovia.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.erya.recipesearch.ProductClickListener
import com.project.giniatovia.presentation.models.Product
import com.project.giniatovia.feature_fridge.presentation.databinding.ProductItemLayoutBinding

class ProductAdapter(private val deleteClickListener: ProductClickListener)
    : ListAdapter<Product, ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.closeImage.setOnClickListener{
            deleteClickListener.onDeleteClick(position)
        }
        holder.bind(getItem(position))
    }

}