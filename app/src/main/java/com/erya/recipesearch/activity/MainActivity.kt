package com.erya.recipesearch.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.erya.recipesearch.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.giniatovia.core.network.data.CSVParser
import com.project.giniatovia.presentation.fragments.FridgeFragment
import com.project.giniatovia.presentation.fragments.RecipeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allIngredients = CSVParser(applicationContext,"ingredients.csv").parse()
        Log.i("TAG", allIngredients.size.toString())
        Log.i("TAG", allIngredients[0])
        Log.i("TAG", allIngredients[999])

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        setBottomNavListener(bottomNavigationView)
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

    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}