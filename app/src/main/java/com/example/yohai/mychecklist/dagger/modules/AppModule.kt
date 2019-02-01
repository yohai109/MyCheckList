package com.example.yohai.mychecklist.dagger.modules

import android.app.Application
import androidx.room.Room
import com.example.yohai.mychecklist.database.AppDatabase
import com.example.yohai.mychecklist.database.daos.CategoryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase = Room.databaseBuilder(app,
            AppDatabase::class.java, "list.db").build()

    @Provides
    @Singleton
    fun provideCategoryDao(database: AppDatabase): CategoryDao = database.categoryDao()
}