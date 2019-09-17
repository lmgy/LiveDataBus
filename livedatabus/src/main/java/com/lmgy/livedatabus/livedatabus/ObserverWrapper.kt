package com.lmgy.livedatabus.livedatabus

import androidx.lifecycle.Observer

/**
 * @author lmgy
 * @date 2019/9/17
 */
class ObserverWrapper<T>(
    private val observer: Observer<in T>,
    private val event: LiveDataEvent<T>,
    private val sticky: Boolean
) : Observer<T> {

    private var mLastVersion = event.mVersion

    override fun onChanged(t: T?) {

        if (mLastVersion >= event.mVersion) {
            if (sticky && event.mStickyEvent != null) {
                observer.onChanged(event.mStickyEvent)
            }
            return
        }
        mLastVersion = event.mVersion

        observer.onChanged(t)
    }

}