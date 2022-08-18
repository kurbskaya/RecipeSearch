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
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val disposable = Single
            .fromCallable{ CSVParser(applicationContext,"ingredients.csv").parse() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ parsedResult ->
                val allIngredients = arrayListOf<String>()
                parsedResult.forEach{ entry -> allIngredients.add(entry.key) }
                Log.i(LOG_TAG, allIngredients.size.toString())
                Log.i(LOG_TAG, allIngredients.first())
                Log.i(LOG_TAG, allIngredients.last())
            }, {
                Log.e(LOG_TAG, it.toString())
            })
        compositeDisposable.add(disposable)

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

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    companion object {
        const val LOG_TAG = "MAIN_ACTIVITY_TAG"
    }
}