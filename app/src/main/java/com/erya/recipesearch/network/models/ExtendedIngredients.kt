package com.erya.recipesearch.network.models

import com.google.gson.annotations.SerializedName

data class ExtendedIngredients(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("name") val name: String? = null,
)
