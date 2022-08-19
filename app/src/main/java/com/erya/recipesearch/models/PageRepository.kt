package com.erya.recipesearch.models

interface PageRepository {
    fun getPages() : ArrayList<Page>
}