package com.project.giniatovia.core_network_api.models

import com.google.gson.annotations.SerializedName

data class AnalyzedInstructions(
    @SerializedName("name"  ) var name  : String?          = null,
    @SerializedName("steps" ) var steps : ArrayList<Step> = arrayListOf()
)