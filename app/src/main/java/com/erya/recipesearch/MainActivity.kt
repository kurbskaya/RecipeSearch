package com.erya.recipesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.erya.recipesearch.data.RetrofitHelper
import com.erya.recipesearch.data.api.RecipesApi
import com.erya.recipesearch.data.mapper.RecipesResponseMapper
import com.erya.recipesearch.data.repository.RecipesRepositoryImpl
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        setBottomNavListener(bottomNavigationView)

        // THIS IS FOR TESTING PURPOSES
        val recipesApi = RetrofitHelper.getInstance().create(RecipesApi::class.java)
        val mapper = RecipesResponseMapper()
        val repo = RecipesRepositoryImpl(recipesApi, mapper)
        val answer = repo.getRandomRecipe().blockingGet()
        Log.i("MAIN_TAG", answer.toString())
    }

    private fun setBottomNavListener(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_fridge -> {
                    loadFragment(FridgeFragment())
                    true
                }
                R.id.page_recipes -> {
                    loadFragment(RecipeFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}