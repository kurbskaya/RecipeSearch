package com.project.giniatovia.feature_recipe.presentation.viewmodels

import androidx.lifecycle.*
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import com.project.giniatovia.feature_recipe.presentation.ViewDataMapper
import com.project.giniatovia.feature_recipe.presentation.models.RecipeInfoViewData
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipesRepository
) : ViewModel() {

    private val _recipeLiveData = MutableLiveData<List<RecipeViewData>>()
    val recipeLiveData: LiveData<List<RecipeViewData>> = _recipeLiveData

    private val _recipeInfoLiveData = MutableLiveData<RecipeInfoViewData>()
    val recipeInfoLiveData: LiveData<RecipeInfoViewData> = _recipeInfoLiveData

//    fun getRandomRecipe() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getRandomRecipe()
//        }
//    }

    fun getRecipeInfoById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _recipeInfoLiveData.postValue(
                ViewDataMapper.mapRecipeInfoToViewData(
                    repository.getRecipeInfoById(id)
                )
            )
        }
    }

    fun getRecipeByIngredients(ingredients: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            _recipeLiveData.postValue(
                ViewDataMapper.mapRecipeToViewData(
                    repository.getRecipeByIngredients(ingredients.joinToString(","))
                )
            )
        }
    }
}