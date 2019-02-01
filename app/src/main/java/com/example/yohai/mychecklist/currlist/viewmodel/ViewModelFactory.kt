package com.example.yohai.mychecklist.currlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yohai.mychecklist.database.Repository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: Repository): ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(CurrListViewModel::class.java!!)) {
                CurrListViewModel(this.repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }

}