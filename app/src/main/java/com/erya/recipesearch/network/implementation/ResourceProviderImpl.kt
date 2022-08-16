package com.erya.recipesearch.network.implementation

import android.content.Context
import com.erya.recipesearch.network.api.ResourceProvider

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun string(id: Int) = context.getString(id)

    override fun string(resId: Int, vararg args: Any?) = context.getString(resId, *args)
}