package com.lmgy.livedatabus.livedatabus

import android.os.Looper
import android.util.Log.e
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author lmgy
 * @date 2019/9/17
 */
class LiveDataEvent<T> : MutableLiveData<T>() {

    var mVersion = VERSION
    var mStickyEvent: T? = null

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        observe(owner, observer, false)
    }

    fun observe(owner: LifecycleOwner, observer: Observer<in T>, sticky: Boolean) {
        super.observe(owner, ObserverWrapper(observer, this, sticky))
    }

    fun post(t: T) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            setValue(t)
        } else {
            postValue(t)
        }
    }

    fun postSticky(t: T) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            setValueSticky(t)
        } else {
            postValueSticky(t)
        }
    }

    override fun setValue(value: T) {
        mVersion++
        super.setValue(value)
    }

    override fun postValue(value: T) {
        mVersion++
        super.postValue(value)
    }

    fun setValueSticky(value: T) {
        mStickyEvent = value
        setValue(value)
    }

    fun postValueSticky(value: T) {
        mStickyEvent = value
        postValue(value)
    }

    fun removeSticky() {
        mStickyEvent = null
    }

    companion object {
        private const val VERSION = -1
    }
}