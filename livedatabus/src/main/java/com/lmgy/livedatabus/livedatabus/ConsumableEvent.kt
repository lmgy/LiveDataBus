package com.lmgy.livedatabus.livedatabus

/**
 * @author lmgy
 * @date 2019/9/17
 */
data class ConsumableEvent(var isConsumed: Boolean = false, var value: Any? = null) {

    fun runAndConsume(runnable: () -> Unit) {
        if (!isConsumed) {
            runnable()
            isConsumed = true
        }
    }

}