package com.erya.recipesearch.data.mapper

import com.erya.recipesearch.data.model.RecipeResponse
import com.erya.recipesearch.data.model.RecipesResponse
import com.erya.recipesearch.domain.model.Recipe

class RecipesResponseMapper {
    fun map(data: RecipesResponse) : Recipe {
        with(data.recipes[0]) {
            return Recipe(
                image = image ?: "INSERT_DEFAULT_IMAGE_URL",
                instructions = instructions ?: "Instruction is not found :(",
                readyInMinutes = readyInMinutes ?: 30,
                servings = servings ?: 2,
                summary = summary ?: "Summary is not found :(",
                title = title ?: "Title is not found :("
            )
        }
    }
}