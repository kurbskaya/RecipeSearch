package com.project.giniatovia.core.network.api

import androidx.annotation.StringRes

interface ResourceProvider {

    fun string(@StringRes id: Int): String

    fun string(@StringRes resId: Int, vararg args: Any?): String
}