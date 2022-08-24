package com.project.giniatovia.core.network.models

import com.google.gson.annotations.SerializedName

class ExtendedIngredients(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("name") val name: String? = null,
)
