package com.project.giniatovia.feature_fridge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.giniatovia.feature_fridge.databinding.ProductItemLayoutBinding
import com.project.giniatovia.feature_recipe.presentation.models.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var ingredients = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    fun getAllIngredients() = ingredients

    override fun getItemCount() = ingredients.size

    fun updateList(newTasks: List<Product>) {
        val tasksDiffUtilCallback = ProductDiffCallback(ingredients, newTasks)
        val tasksDiffResult = DiffUtil.calculateDiff(tasksDiffUtilCallback)
        ingredients = newTasks.toMutableList()
        tasksDiffResult.dispatchUpdatesTo(this)
    }

    fun addToEnd(product: Product) {
        ingredients.add(product)
        notifyItemInserted(itemCount)
    }

    class ProductViewHolder(
        private val binding: ProductItemLayoutBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product){
            binding.name.text = product.name
        }
    }
}