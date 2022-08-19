package com.project.giniatovia.feature_fridge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.giniatovia.feature_fridge.databinding.ItemProductBinding
import com.project.giniatovia.feature_fridge.presentation.models.Product

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductViewHolder(productItemLayoutBinding: ItemProductBinding)
        : RecyclerView.ViewHolder(productItemLayoutBinding.root) {

        private val binding = productItemLayoutBinding

        fun bind(product: Product) {
            binding.name.text = product.name
            binding.energy.text = product.energy
            Glide.with(binding.productImage.context)
                .load(product.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.productImage)
        }
    }

}