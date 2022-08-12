package com.erya.recipesearch.data.mapper

import com.erya.recipesearch.data.model.RecipeResponse
import com.erya.recipesearch.data.model.RecipesResponse
import com.erya.recipesearch.domain.model.Recipe

class RecipesResponseMapper {
    fun map(data: RecipesResponse) : Recipe {
        with(data.recipes[0]) {
            return Recipe(
                image = image,
                instructions = instructions,
                readyInMinutes = readyInMinutes,
                servings = servings,
                summary = summary,
                title = title
            )
        }
    }
}