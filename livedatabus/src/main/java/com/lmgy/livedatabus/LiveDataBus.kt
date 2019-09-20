package com.lmgy.livedatabus

import java.util.concurrent.ConcurrentHashMap

/**
 * @author lmgy
 * @date 2019/9/17
 */
object LiveDataBus{

    private val subjectMap = ConcurrentHashMap<Class<*>, LiveDataEvent<*>>()

    private fun <T> bus(clazz: Class<T>) = subjectMap.getOrPut(clazz) {
        LiveDataEvent<T>()
    }

    fun <T> with(clazz: Class<T>) = bus(clazz) as LiveDataEvent<T>

}
