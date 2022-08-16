package com.erya.recipesearch.network.api

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun string(@StringRes id: Int): String

    fun string(@StringRes resId: Int, vararg args: Any?): String
}