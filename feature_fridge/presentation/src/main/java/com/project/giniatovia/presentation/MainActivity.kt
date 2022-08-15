package com.project.giniatovia.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.giniatovia.feature_fridge.presentation.R
import com.project.giniatovia.presentation.fragments.FridgeFragment
import com.project.giniatovia.presentation.fragments.RecipeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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