package com.lmgy.livedatabus.livedatabus

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @author lmgy
 * @date 2019/9/17
 */
class LiveDataEvent(private val mSubject: String) : LiveData<ConsumableEvent>() {

    fun update(event: ConsumableEvent) = postValue(event)

    override fun removeObserver(observer: Observer<in ConsumableEvent>) {
        super.removeObserver(observer)
        if (!hasObservers()) {
            LiveDataBus.unregister(mSubject)
        }
    }

    override fun removeObservers(owner: LifecycleOwner) {
        super.removeObservers(owner)
        if (!hasObservers()) {
            LiveDataBus.unregisterAll()
        }
    }
}