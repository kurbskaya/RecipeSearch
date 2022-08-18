package com.project.giniatovia.core.network.data

import android.content.Context
import android.util.Log

class CSVParser(private val context: Context, private val filename: String) {
    fun parse(): Map<String, Int> {
        val parsed = HashMap<String, Int>()
        context.assets
            .open(filename)
            .bufferedReader()
            .use { it.readLines() }
            .forEach {
                val pair = it.split(';')
                parsed[pair[0].replaceFirstChar { ch -> ch.uppercase() }] = pair[1].toInt()
            }
        return parsed
    }
}