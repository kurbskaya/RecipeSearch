package com.project.giniatovia.feature_recipe.presentation.viewmodels

import androidx.lifecycle.*
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import com.project.giniatovia.feature_recipe.presentation.ViewDataMapper
import com.project.giniatovia.feature_recipe.presentation.models.RecipeInfoViewData
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData
import com.project.giniatovia.feature_recipe.presentation.models.UiItemError
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipesRepository
) : ViewModel() {

    private val _recipeLiveData = MutableLiveData<UiItemError<List<RecipeViewData>>>()
    val recipeLiveData: LiveData<UiItemError<List<RecipeViewData>>> = _recipeLiveData

    private val _recipeInfoLiveData = MutableLiveData<UiItemError<RecipeInfoViewData>>()
    val recipeInfoLiveData: LiveData<UiItemError<RecipeInfoViewData>> = _recipeInfoLiveData

    private val _isSavedRecipe = MutableLiveData<Boolean>()
    val isSavedRecipe: LiveData<Boolean> = _isSavedRecipe

    fun insertRecipeDb(recipe: RecipeInfoViewData) = viewModelScope.launch {
        repository.insertRecipe(
            ViewDataMapper.mapInfoViewDataToRecipeEntity(recipe)
        )
    }

    fun getSavedRecipes() {
        viewModelScope.launch {
            runCatching {
                repository.getSavedRecipes().map { ViewDataMapper.mapRecipeEntityToViewData(it) }
            }.onSuccess { recipes ->
                _recipeLiveData.value = UiItemError.Success(recipes)
            }.onFailure { exception ->
                _recipeLiveData.value = UiItemError.Error(exception)
            }
        }
    }

    fun getRecipeInfoById(id: Int) {
        viewModelScope.launch {
            runCatching {
                repository.getRecipeInfoById(id)
            }.onSuccess { info ->
                _recipeInfoLiveData.value = UiItemError.Success(
                    ViewDataMapper.mapRecipeInfoToViewData(info)
                )
            }.onFailure { exception ->
                _recipeInfoLiveData.value = UiItemError.Error(exception)
            }

        }
    }

    fun getRecipeByIngredients(ingredients: List<String>) {
        viewModelScope.launch {
            runCatching {
                repository.getRecipeByIngredients(ingredients.joinToString(","))
            }.onSuccess { recipes ->
                _recipeLiveData.value = UiItemError.Success(
                    ViewDataMapper.mapRecipeToViewData(recipes)
                )
            }.onFailure { exception ->
                _recipeLiveData.value = UiItemError.Error(exception)
            }
        }
    }

    fun deleteRecipeDb(recipe: RecipeInfoViewData) = viewModelScope.launch {
        repository.deleteRecipe(
            ViewDataMapper.mapInfoViewDataToRecipeEntity(recipe)
        )
    }

    fun clearLiveData() {
        _recipeLiveData.value = UiItemError.Success(arrayListOf())
    }

    fun searchDb(recipeId: Int) =
        viewModelScope.launch {
            _isSavedRecipe.value = repository.searchRecipe(recipeId)
        }
}