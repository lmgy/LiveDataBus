package com.lmgy.livedatabus

import java.util.concurrent.ConcurrentHashMap

/**
 * @author lmgy
 * @date 2019/9/17
 */
class LiveDataBus private constructor(){

    private val subjectMap = ConcurrentHashMap<Class<*>, LiveDataEvent<*>>()

    private fun <T> bus(clazz: Class<T>) = subjectMap.getOrPut(clazz) {
        LiveDataEvent<T>()
    }

    fun <T> with(clazz: Class<T>) = bus(clazz) as LiveDataEvent<T>

    companion object {
        @Volatile
        private var instance: LiveDataBus? = null

        @JvmStatic
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: LiveDataBus().also { instance = it }
        }
    }

}
