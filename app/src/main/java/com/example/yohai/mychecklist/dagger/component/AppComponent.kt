package com.example.yohai.mychecklist.dagger.component

import com.example.yohai.mychecklist.MyCheckList
import com.example.yohai.mychecklist.dagger.modules.AppModule
import com.example.yohai.mychecklist.dagger.modules.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class]
)
interface AppComponent {
    fun inject(app: MyCheckList)
}