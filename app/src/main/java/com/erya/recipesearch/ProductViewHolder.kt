package com.erya.recipesearch

import androidx.recyclerview.widget.RecyclerView
import com.erya.recipesearch.databinding.ProductItemLayoutBinding

class ProductViewHolder(productItemLayoutBinding: ProductItemLayoutBinding)
    : RecyclerView.ViewHolder(productItemLayoutBinding.root) {

    val binding = productItemLayoutBinding

    fun bind(product: Product){
        binding.name.text = product.name
        binding.energy.text = product.energy
        binding.productImage.showIcon(product.image)

    }
}