package com.example.yohai.mychecklist.dagger.component

import android.app.Application
import com.example.yohai.mychecklist.dagger.AppModule
import com.example.yohai.mychecklist.dagger.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(AndroidInjectionModule::class, AppModule::class)
)
interface AppComponent {
    fun inject(app: Application)
}