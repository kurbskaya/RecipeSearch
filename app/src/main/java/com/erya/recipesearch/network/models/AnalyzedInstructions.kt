package com.erya.recipesearch.network.models

import com.google.gson.annotations.SerializedName

data class AnalyzedInstructions(
    @SerializedName("name") val name: String? = null,
    @SerializedName("steps") val steps: ArrayList<Step> = arrayListOf()
)