package com.example.yohai.mychecklist

import android.app.Activity
import android.app.Application
import com.example.yohai.mychecklist.dagger.modules.AppModule
import com.example.yohai.mychecklist.dagger.component.DaggerAppComponent
import com.example.yohai.mychecklist.dagger.modules.BuildersModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


class MyCheckList: Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

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

        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    inner class MyLogTree: Timber.DebugTree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            Logger.log(priority, tag, message, t)
        }
    }
}