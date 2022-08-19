package com.erya.recipesearch.data.repository

import com.erya.recipesearch.R
import com.erya.recipesearch.models.Page
import com.erya.recipesearch.models.PageRepository

class PageRepositoryImpl : PageRepository {
    override fun getPages(): ArrayList<Page> {
        return arrayListOf(
            Page("description1", R.raw.first_page),
            Page("description2", R.raw.second_page),
            Page("description3", R.raw.third_page)
        )
    }
}