package com.project.giniatovia.feature_recipe.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.project.giniatovia.domain.models.Recipe
import com.project.giniatovia.feature_recipe.domain.repository.RecipesRepository
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipesRepository
) : ViewModel() {

    private val _recipeLiveData = MutableLiveData<Recipe>()
    val recipeLiveData: LiveData<Recipe> = _recipeLiveData

    fun getRandomRecipe() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRandomRecipe().subscribeOn(Schedulers.io())
                .subscribe({
                    _recipeLiveData.postValue(it.recipes.get(0))
                }, {
                    it.printStackTrace()
                })
        }
    }

    fun getRecipeByIngredients(ingredients: Array<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRecipeByIngredients(ingredients.joinToString(",")).subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("TAG", it.toString())
                }, {
                    it.printStackTrace()
                })
        }
    }
}