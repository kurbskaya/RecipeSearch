package com.project.giniatovia.core.network.data

import android.content.Context

class CSVParser(private val context: Context, private val filename: String) {
    fun parse(): List<String> {
        val list = mutableListOf<String>()
        context.assets
            .open(filename)
            .bufferedReader()
            .use { it.readLines() }
            .forEach {
                val pair = it.split(';')
                list.add(pair[0].replaceFirstChar { ch -> ch.uppercase() })
            }
        return list
    }
}