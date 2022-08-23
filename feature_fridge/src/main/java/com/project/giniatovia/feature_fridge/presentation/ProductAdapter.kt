package com.project.giniatovia.feature_fridge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.giniatovia.feature_fridge.databinding.ItemProductBinding
import com.project.giniatovia.core.network.models.Product

class ProductAdapter(private val onDeleteProductClick:  (item: Product) -> Unit)
    : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding, onDeleteProductClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ProductViewHolder(
        productItemLayoutBinding: ItemProductBinding,
        onDeleteProductClick: (item: Product) -> Unit,
    ) : RecyclerView.ViewHolder(productItemLayoutBinding.root) {

        private var cell: Product? = null
        private val binding = productItemLayoutBinding

        init {
            binding.imageClose.setOnClickListener{
                cell?.let { it1 -> onDeleteProductClick(it1) }
            }
        }

        fun bind(product: Product) {
            this.cell = product
            binding.name.text = product.name
            binding.energy.text = product.energy
            Glide.with(binding.productImage.context)
                .load(product.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.productImage)
        }
    }

}