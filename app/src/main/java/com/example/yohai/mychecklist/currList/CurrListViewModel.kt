package com.example.yohai.mychecklist.currList

import androidx.lifecycle.ViewModel
import com.example.yohai.mychecklist.ListRepo

class CurrListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val listRepo = ListRepo()

    fun getList(name: String)= listRepo.getList(name)
}
