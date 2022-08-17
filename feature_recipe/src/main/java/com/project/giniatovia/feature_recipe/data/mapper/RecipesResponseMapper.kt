package com.project.giniatovia.feature_recipe.data.mapper

import com.project.giniatovia.core.network.models.RecipesList
import com.project.giniatovia.domain.models.RecipesList as DomainRecipeList
import com.project.giniatovia.domain.models.Recipe as DomainRecipe
import com.project.giniatovia.domain.models.Step as DomainStep
import com.project.giniatovia.domain.models.ExtendedIngredients as DomainExtendedIngredients
import com.project.giniatovia.domain.models.AnalyzedInstructions as DomainAnalyzedInstructions

class RecipesResponseMapper {
    fun map(data: RecipesList): DomainRecipeList {
        return DomainRecipeList(
            data.recipes.map { recipe ->
                DomainRecipe(
                    recipe.extendedIngredients.map {
                        DomainExtendedIngredients(
                            it.id,
                            it.image,
                            it.name
                        )
                    },
                    recipe.id,
                    recipe.title,
                    recipe.image,
                    recipe.summary,
                    recipe.instructions,
                    recipe.analyzedInstructions.map { instructions ->
                        DomainAnalyzedInstructions(
                            instructions.name,
                            instructions.steps.map { step ->
                                DomainStep(
                                    step.number,
                                    step.step
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}
