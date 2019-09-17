package com.lmgy.livedatabus.livedatabus

import androidx.annotation.NonNull
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import java.util.concurrent.ConcurrentHashMap

/**
 * @author lmgy
 * @date 2019/9/17
 */
object LiveDataBus {

    private val subjectMap = ConcurrentHashMap<String, LiveDataEvent>()

    @NonNull
    private fun getLiveData(subjectCode: String): LiveDataEvent {
        var liveData: LiveDataEvent? = subjectMap[subjectCode]
        if (liveData == null) {
            liveData = LiveDataEvent(subjectCode)
            subjectMap[subjectCode] = liveData
        }
        return liveData
    }

    fun subscribe(subject: String, @NonNull lifecycle: LifecycleOwner, @NonNull action: Observer<ConsumableEvent>) {
        try {
            getLiveData(subject).observe(lifecycle, action)
        } catch (throwable: IllegalArgumentException) {
            throwable.printStackTrace()
        }
    }

    fun unregister(subject: String) = subjectMap.remove(subject)

    fun unregisterAll() = subjectMap.clear()

    fun publish(subject: String, message: ConsumableEvent = ConsumableEvent()) =
        getLiveData(subject).update(message)

}
