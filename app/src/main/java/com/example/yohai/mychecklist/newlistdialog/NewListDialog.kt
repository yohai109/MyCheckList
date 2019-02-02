package com.example.yohai.mychecklist.newlistdialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.R
import com.example.yohai.mychecklist.currlist.viewmodel.CurrListViewModel
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ListEntity
import kotlinx.android.synthetic.main.add_list_dialog.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewListDialog: DialogFragment() {

    private lateinit var viewModel: CurrListViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            viewModel = ViewModelProviders.of(it).get(CurrListViewModel::class.java)
            AlertDialog.Builder(it).apply {
                setView(layoutInflater.inflate(R.layout.add_list_dialog, null))
                setPositiveButton("OK") { _, _ -> positiveClick() }
                setNegativeButton("cancel") { _, _ -> dialog.cancel() }

            }.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }

    private fun positiveClick(){
        val newList = if (viewModel.allCategories?.value.isNullOrEmpty()) {
            GlobalScope.launch {
                viewModel.insert(CategoryEntity("new category"))
            }
            ListEntity(new_list_name.text.toString(),"new category")
        } else {
            ListEntity(new_list_name.text.toString(), viewModel.allCategories!!.value!![0].categoryName)
        }

        GlobalScope.launch {
            viewModel.insert(newList)
        }
    }
}