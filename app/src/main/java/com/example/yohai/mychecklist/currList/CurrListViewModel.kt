package com.example.yohai.mychecklist.currList

import android.arch.persistence.room.Room
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.yohai.mychecklist.database.AppDatabase

class CurrListViewModel(content: Context) : ViewModel() {
    // TODO: Implement the ViewModel
    private val DB = Room.databaseBuilder(
            content,
            AppDatabase::class.java, "database-name"
    ).build()

    fun getList(name: String)= emptyList<String>()
}
