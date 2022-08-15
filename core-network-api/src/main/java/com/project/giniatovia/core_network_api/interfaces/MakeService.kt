package com.project.giniatovia.core_network_api.interfaces

interface MakeService {

    fun <T> service(clasz: Class<T>): T

    abstract class Abstract(
        private val retrofit: ProvideRetrofit,
    ) : MakeService {

        override fun <T> service(clasz: Class<T>): T = retrofit.provideRetrofit().create(clasz)
    }
}