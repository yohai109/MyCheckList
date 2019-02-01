package com.example.yohai.mychecklist.currlist.viewmodel

import android.app.Application

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.yohai.mychecklist.database.Repository
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ListEntity
import javax.inject.Inject

class CurrListViewModel@Inject constructor(private val repo: Repository) : ViewModel() {
    var allCategories: LiveData<List<CategoryEntity>>?  = repo.getCategories()

    fun insert(category: CategoryEntity) = repo.insertCategory(category)

    suspend fun insert(list:ListEntity) = repo.addNewList(listOf(list))
}
