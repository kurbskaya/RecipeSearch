package com.project.giniatovia.domain.models

data class AnalyzedInstructions(
    val name  : String?          = null,
    val steps : List<Step> = listOf()
)