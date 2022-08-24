package com.project.giniatovia.core.network.models

import com.google.gson.annotations.SerializedName

class AnalyzedInstructions(
    @SerializedName("name") val name: String? = null,
    @SerializedName("steps") val steps: List<Step> = listOf()
)