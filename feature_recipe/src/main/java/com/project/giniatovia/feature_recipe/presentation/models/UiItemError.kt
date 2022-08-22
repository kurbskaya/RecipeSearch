package com.project.giniatovia.feature_recipe.presentation.models

sealed class UiItemError<out T> {
    class Success<R>(val elements: R?) : UiItemError<R>()
    class Error(val exception: Throwable?) : UiItemError<Nothing>()
}
