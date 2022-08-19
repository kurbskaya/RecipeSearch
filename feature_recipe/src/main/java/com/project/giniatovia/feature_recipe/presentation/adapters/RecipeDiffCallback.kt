package com.project.giniatovia.feature_recipe.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.project.giniatovia.domain.models.Recipe

class RecipeDiffCallback: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return (oldItem == newItem)
    }
}