package com.project.giniatovia.core_network_api.models

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("extendedIngredients"      ) var extendedIngredients      : List<ExtendedIngredients>  = listOf(),
    @SerializedName("id"                       ) var id                       : Int?                            = null,
    @SerializedName("title"                    ) var title                    : String?                         = null,
    @SerializedName("image"                    ) var image                    : String?                         = null,
    @SerializedName("summary"                  ) var summary                  : String?                         = null,
    @SerializedName("instructions"             ) var instructions             : String?                         = null,
    @SerializedName("analyzedInstructions"     ) var analyzedInstructions     : List<AnalyzedInstructions> = listOf(),
)