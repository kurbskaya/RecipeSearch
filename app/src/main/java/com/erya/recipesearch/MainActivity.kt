package com.erya.recipesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        setBottomNavListener(bottomNavigationView)
    }

    private fun setBottomNavListener(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.page_fridge -> {
                    fragment = FridgeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.page_recipes -> {
                    fragment = RecipeFragment()
                    loadFragment(fragment)
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