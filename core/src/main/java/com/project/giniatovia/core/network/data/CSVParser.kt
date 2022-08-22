package com.project.giniatovia.core.network.data

import android.content.Context

class CSVParser(private val context: Context, private val filename: String) {
    fun parse(): List<String> {
        return context.assets
                .open(filename)
                .bufferedReader()
                .use { it.readLines() }
                .map { it.substringBefore(';').replaceFirstChar { ch -> ch.uppercase() } }
    }
}