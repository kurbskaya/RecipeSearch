package com.project.giniatovia.core.network.models

import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("number") val number: Int? = null,
    @SerializedName("step") val step: String? = null,
)