package com.project.giniatovia.core.network.implementation

import android.content.Context
import com.project.giniatovia.core.network.api.ResourceProvider

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun string(id: Int) = context.getString(id)

    override fun string(resId: Int, vararg args: Any?) = context.getString(resId, *args)
}