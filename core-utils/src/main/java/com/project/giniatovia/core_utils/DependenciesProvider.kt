package com.project.giniatovia.core_utils

import kotlin.reflect.KClass

interface DependenciesProvider {
    fun <T : Any> get(clazz: KClass<T>): T
}
