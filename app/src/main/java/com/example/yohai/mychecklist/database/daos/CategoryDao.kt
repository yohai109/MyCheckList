package com.example.yohai.mychecklist.database.daos

import androidx.room.Insert
import androidx.room.Query
import androidx.lifecycle.LiveData
import com.example.yohai.mychecklist.database.entities.CategoryEntity

interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getAll(): LiveData<List<CategoryEntity>>

    @Insert
    fun save(newCategories: List<CategoryEntity>)
}