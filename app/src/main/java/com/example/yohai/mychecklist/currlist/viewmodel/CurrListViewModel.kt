package com.example.yohai.mychecklist.currlist.viewmodel

import android.app.Application

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.yohai.mychecklist.database.Repository
import com.example.yohai.mychecklist.database.entities.CategoryEntity

class CurrListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var repo: Repository? = null
    var allCategories: LiveData<List<CategoryEntity>>? = null

    fun initRepo(application: Application){
        repo = Repository(application)
        allCategories = repo?.getCategories()
    }

    fun insert(category: CategoryEntity) = repo?.insertCategory(category)
}
