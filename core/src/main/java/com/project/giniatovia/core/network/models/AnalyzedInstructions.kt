package com.project.giniatovia.core.network.models

data class AnalyzedInstructions(
    val name: String? = null,
    val steps: List<Step> = listOf()
)