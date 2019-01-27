package com.example.yohai.mychecklist.currlist

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.yohai.mychecklist.database.Repository
import com.example.yohai.mychecklist.database.entities.CategoryEntity

class CurrListVieModel() : ViewModel() {
    // TODO: Implement the ViewModel
    private var repo: Repository? = null
    internal var allCaegories: LiveData<List<CategoryEntity>>? = null

    fun initRepo(application: Application){
        repo = Repository(application)
        allCaegories = repo?.getCategories()
    }

    fun insert(category: CategoryEntity) = repo?.insertCategory(category)
}
