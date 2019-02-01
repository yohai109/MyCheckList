package com.example.yohai.mychecklist.database.daos

import androidx.room.Insert
import androidx.room.Query
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.yohai.mychecklist.database.entities.CategoryAllLists
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ListEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getAll(): LiveData<List<CategoryEntity>>

    @Insert
    fun addCategory(newCategories: List<CategoryEntity>)

    @Insert
    fun addList(newList: List<ListEntity>)
}