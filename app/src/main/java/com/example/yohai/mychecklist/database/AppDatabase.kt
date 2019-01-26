package com.example.yohai.mychecklist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.yohai.mychecklist.database.daos.CategoryDao
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ItemEntity
import com.example.yohai.mychecklist.database.entities.ListEntity

@Database(entities = [CategoryEntity::class, ListEntity::class, ItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CategotyDao(): CategoryDao
}