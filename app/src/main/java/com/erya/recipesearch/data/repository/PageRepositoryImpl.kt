package com.erya.recipesearch.data.repository

import com.erya.recipesearch.R
import com.erya.recipesearch.models.Page
import com.erya.recipesearch.models.PageRepository

class PageRepositoryImpl : PageRepository {
    override fun getPages(): ArrayList<Page> {
        return arrayListOf(
            Page("Choose the products you have", R.raw.first_page),
            Page("And we will give you the recipe for them", R.raw.second_page),
            Page("Save your favourite recipe", R.raw.third_page)
        )
    }
}