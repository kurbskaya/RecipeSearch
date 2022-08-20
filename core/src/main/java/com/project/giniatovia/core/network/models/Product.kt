package com.project.giniatovia.core.network.models

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("energy") val energy: String = "",
    @SerializedName("image") val image: String = "",
)