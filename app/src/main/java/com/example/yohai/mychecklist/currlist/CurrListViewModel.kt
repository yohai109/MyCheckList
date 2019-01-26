package com.example.yohai.mychecklist.currlist

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.yohai.mychecklist.database.Repository
import com.example.yohai.mychecklist.database.entities.CategoryEntity

class CurrListViewModel(application: Application) : ViewModel() {
    // TODO: Implement the ViewModel
    private val repo = Repository(application)
    internal val allCategories = repo.getCategories()

    fun insert(category: CategoryEntity) = repo.insertCategory(category)
}
