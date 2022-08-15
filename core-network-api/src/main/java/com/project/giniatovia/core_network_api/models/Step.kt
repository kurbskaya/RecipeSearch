package com.project.giniatovia.core_network_api.models

import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("number"      ) var number      : Int?                   = null,
    @SerializedName("step"        ) var step        : String?                = null,
)