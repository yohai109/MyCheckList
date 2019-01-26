package com.example.yohai.mychecklist

class ListRepo {

    private var lists: HashMap<String, List<String>> = hashMapOf()

    fun addList(newList: List<String>, name: String){
        lists[name] = newList
    }

    fun getList(name:String) = lists[name]
}