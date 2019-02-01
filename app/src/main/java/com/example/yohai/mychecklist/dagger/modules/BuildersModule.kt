package com.example.yohai.mychecklist.dagger.modules

import com.example.yohai.mychecklist.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeActivityInjector(): MainActivity
}