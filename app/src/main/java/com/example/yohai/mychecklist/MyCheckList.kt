package com.example.yohai.mychecklist

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import timber.log.Timber


class MyCheckList: Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())

        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
            Timber.plant(MyLogTree())
        } else {
//            Timber.plant(Timber.DebugTree())
            Timber.plant(MyLogTree())
        }
    }

    inner class MyLogTree: Timber.DebugTree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            Logger.log(priority, tag, message, t)
        }
    }
}