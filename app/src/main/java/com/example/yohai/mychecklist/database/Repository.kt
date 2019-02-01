package com.example.yohai.mychecklist.database

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.yohai.mychecklist.database.daos.CategoryDao
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ListEntity
import javax.inject.Inject

class Repository @Inject constructor(private val categoriesDao: CategoryDao) {

    private val listLiveData: LiveData<List<CategoryEntity>> = categoriesDao.getAll()

    fun getCategories() = listLiveData

    fun getCategoryNames():List<String>?{
        return listLiveData.value?.map { it.categoryName }
    }

    suspend fun addNewList(lists: List<ListEntity>) = categoriesDao.addList(lists)

    fun insertCategory(category: CategoryEntity) = InsertAsyncTask(categoriesDao).execute(category)!!

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: CategoryDao) : AsyncTask<CategoryEntity, Void, Void>() {

        override fun doInBackground(vararg params: CategoryEntity): Void? {
            mAsyncTaskDao.addCategory(params.asList())
            return null
        }
    }
}