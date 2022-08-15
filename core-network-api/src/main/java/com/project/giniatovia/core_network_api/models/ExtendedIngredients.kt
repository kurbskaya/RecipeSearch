package com.project.giniatovia.core_network_api.models

import com.google.gson.annotations.SerializedName

data class ExtendedIngredients(
    @SerializedName("id"           ) var id           : Int?              = null,
    @SerializedName("image"        ) var image        : String?           = null,
    @SerializedName("name"         ) var name         : String?           = null,
)
