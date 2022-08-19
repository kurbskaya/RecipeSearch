package com.project.giniatovia.feature_recipe.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.giniatovia.domain.models.Recipe
import com.project.giniatovia.feature_recipe.databinding.ItemRecipeBinding

class RecipesAdapter(private val recipeClickListener: RecipeClickListener) : ListAdapter<String, RecipesAdapter.RecipesViewHolder>(RecipeDiffCallback()) {

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
            recipeClickListener.recipeClick(id)
        }
        holder.bind(getItem(position))
    }

    class RecipesViewHolder(recipeItemLayoutBinding: ItemRecipeBinding)
        : RecyclerView.ViewHolder(recipeItemLayoutBinding.root) {
        val binding = recipeItemLayoutBinding

        fun bind(recipe: String) {
            binding.text1.text = recipe
            // TODO:  
            Glide.with(binding.productImage.context)
                .load("https://spoonacular.com/recipeImages/715594-312x231.jpg")
                .circleCrop()
                .into(binding.productImage)
        }
    }
}