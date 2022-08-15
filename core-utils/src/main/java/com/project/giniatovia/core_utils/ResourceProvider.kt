package com.project.giniatovia.core_utils

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun string(@StringRes id: Int): String

    fun string(@StringRes resId: Int, vararg args: Any?): String

    class Base(private val context: Context) : ResourceProvider {
        override fun string(id: Int) = context.getString(id)

        override fun string(resId: Int, vararg args: Any?) = context.getString(resId, *args)
    }
}