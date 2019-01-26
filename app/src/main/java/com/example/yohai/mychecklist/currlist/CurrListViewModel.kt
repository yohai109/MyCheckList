package com.example.yohai.mychecklist.currlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.yohai.mychecklist.database.Repository
import com.example.yohai.mychecklist.database.entities.CategoryEntity

class CurrListViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = Repository(getApplication())
    internal val allCategories = repo.getCategories()


    fun insert(category: CategoryEntity) = repo.insertCategory(category)
}
