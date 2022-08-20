package com.project.giniatovia.feature_recipe.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData

class RecipeDiffCallback: DiffUtil.ItemCallback<RecipeViewData>() {
    override fun areItemsTheSame(oldItem: RecipeViewData, newItem: RecipeViewData) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RecipeViewData, newItem: RecipeViewData) =
        oldItem.id == newItem.id && oldItem.title == newItem.title
}