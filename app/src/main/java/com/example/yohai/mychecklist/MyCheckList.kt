package com.example.yohai.mychecklist

import android.app.Application
import timber.log.Timber

class MyCheckList: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(Timber.DebugTree())
        }
    }
}