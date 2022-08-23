package com.project.giniatovia.feature_recipe.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.giniatovia.feature_recipe.databinding.ItemRecipeBinding
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData

class RecipesAdapter(private val onRecipeClick:  (item: RecipeViewData) -> Unit)
    : ListAdapter<RecipeViewData, RecipesAdapter.RecipesViewHolder>(RecipeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val id = getItem(position)
        holder.itemView.setOnClickListener{
            onRecipeClick(id)
        }
        holder.bind(getItem(position))
    }

    class RecipesViewHolder(recipeItemLayoutBinding: ItemRecipeBinding)
        : RecyclerView.ViewHolder(recipeItemLayoutBinding.root) {
        val binding = recipeItemLayoutBinding

        fun bind(recipe: RecipeViewData) {
            binding.text1.text = recipe.title
            // TODO:  
            Glide.with(binding.productImage.context)
                .load(recipe.image)
                .circleCrop()
                .into(binding.productImage)
        }
    }
}