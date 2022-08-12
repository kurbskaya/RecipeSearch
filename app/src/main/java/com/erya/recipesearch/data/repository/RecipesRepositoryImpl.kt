package com.erya.recipesearch.data.repository

import androidx.lifecycle.LifecycleCoroutineScope
import com.erya.recipesearch.data.api.RecipesApi
import com.erya.recipesearch.data.mapper.RecipesResponseMapper
import com.erya.recipesearch.data.model.RecipesResponse
import com.erya.recipesearch.domain.model.Recipe
import com.erya.recipesearch.domain.repository.RecipesRepository
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class RecipesRepositoryImpl (
    private val api: RecipesApi,
    private val mapper: RecipesResponseMapper
    ) : RecipesRepository {
    override fun getRandomRecipe(): Single<Recipe> {
        return api.getRandomRecipe().map { mapper.map(it) }
    }
}