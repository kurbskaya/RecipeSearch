package com.project.giniatovia.core.network.data

import android.content.Context

fun Context.parse(filename: String): Map<String, Int> {
    val parsed = HashMap<String, Int>()
    assets
        .open(filename)
        .bufferedReader()
        .use { it.readLines() }
        .forEach {
            val pair = it.split(';')
            parsed[pair[0].replaceFirstChar { ch -> ch.uppercase() }] = pair[1].toInt()
        }
    return parsed
}