package com.project.giniatovia.feature_recipe.presentation.viewmodels

import androidx.lifecycle.*
import com.project.giniatovia.core.db.models.RecipeEntity
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import com.project.giniatovia.feature_recipe.presentation.ViewDataMapper
import com.project.giniatovia.feature_recipe.presentation.models.RecipeInfoViewData
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipesRepository
) : ViewModel() {

    private val _recipeLiveData = MutableLiveData<List<RecipeViewData>>()
    val recipeLiveData: LiveData<List<RecipeViewData>> = _recipeLiveData

    private val _recipeInfoLiveData = MutableLiveData<RecipeInfoViewData>()
    val recipeInfoLiveData: LiveData<RecipeInfoViewData> = _recipeInfoLiveData

//    private val _savedRecipeLiveData = MutableLiveData<List<RecipeViewData>>()
//    val savedRecipeLiveData: LiveData<List<RecipeViewData>> = _savedRecipeLiveData

    fun insertRecipeDb(recipe: RecipeInfoViewData) = viewModelScope.launch {
        repository.insertRecipe(
            ViewDataMapper.mapInfoViewDataToRecipeEntity(recipe)
        )
//        val oldList = _recipeLiveData.value
//        if (oldList == null){
//            _recipeLiveData.value = arrayListOf(
//                ViewDataMapper.mapRecipeEntityToViewData(recipe)
//            )
//            return@launch
//        }
//        val tmp = ArrayList<RecipeViewData>(oldList)
//        tmp.add(
//            ViewDataMapper.mapRecipeEntityToViewData(recipe)
//        )
//        _recipeLiveData.value = tmp
    }

    fun getSavedRecipes() {
        viewModelScope.launch {
            _recipeLiveData.value = repository.getSavedRecipes().map { ViewDataMapper.mapRecipeEntityToViewData(it) }
        }
    }

    fun getRecipeInfoById(id: Int) {
        viewModelScope.launch {
            _recipeInfoLiveData.postValue(
                ViewDataMapper.mapRecipeInfoToViewData(
                    repository.getRecipeInfoById(id)
                )
            )
        }
    }

    fun getRecipeByIngredients(ingredients: List<String>) {
        viewModelScope.launch {
            _recipeLiveData.postValue(
                ViewDataMapper.mapRecipeToViewData(
                    repository.getRecipeByIngredients(ingredients.joinToString(","))
                )
            )
        }
    }

    fun clearLiveData() {
        _recipeLiveData.value = arrayListOf()
    }
}