package com.example.yohai.mychecklist.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.yohai.mychecklist.database.daos.CategoryDao
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import javax.inject.Inject

class Repository @Inject constructor(private val categoriesDao: CategoryDao) {

    private val listLiveData: LiveData<List<CategoryEntity>> = categoriesDao.getAll()

    fun getCategories() = listLiveData

    fun insertCategory(category: CategoryEntity) = InsertAsyncTask(categoriesDao).execute(category)!!

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: CategoryDao) : AsyncTask<CategoryEntity, Void, Void>() {

        override fun doInBackground(vararg params: CategoryEntity): Void? {
            mAsyncTaskDao.save(params.asList())
            return null
        }
    }
}