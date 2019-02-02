package com.example.yohai.mychecklist.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ItemEntity
import com.example.yohai.mychecklist.database.entities.ListEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getAll(): LiveData<List<CategoryEntity>>

    @Insert
    fun addCategory(newCategories: List<CategoryEntity>)

    @Insert
    fun addList(newList: List<ListEntity>)

    @Query("SELECT * FROM items WHERE category_name == :category AND list_name == :list")
    fun getAllItems(category: String, list: String): LiveData<List<ItemEntity>>
}