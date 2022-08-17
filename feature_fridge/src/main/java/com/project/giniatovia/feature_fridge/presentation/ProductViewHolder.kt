package com.project.giniatovia.feature_fridge.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.giniatovia.feature_fridge.databinding.ProductItemLayoutBinding
import com.project.giniatovia.presentation.models.Product

class ProductViewHolder(productItemLayoutBinding: ProductItemLayoutBinding)
    : RecyclerView.ViewHolder(productItemLayoutBinding.root) {

    val binding = productItemLayoutBinding

    fun bind(product: Product){
        binding.name.text = product.name
        binding.energy.text = product.energy
        Glide.with(binding.productImage.context)
            .load(product.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.productImage)
    }
}