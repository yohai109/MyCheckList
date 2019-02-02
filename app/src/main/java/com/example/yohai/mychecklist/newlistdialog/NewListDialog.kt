package com.example.yohai.mychecklist.newlistdialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.R
import com.example.yohai.mychecklist.currlist.viewmodel.CurrListViewModel
import com.example.yohai.mychecklist.database.entities.ListEntity
import kotlinx.android.synthetic.main.add_list_dialog.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewListDialog: DialogFragment() {

    companion object {
        fun newInstance(category: String): NewListDialog {
            return NewListDialog().apply {
                arguments = Bundle(1).apply {
                    putString(CATEGORY_ARGUMENT, category)
                }
            }
        }

        private const val CATEGORY_ARGUMENT = "categoryName"
    }

    private lateinit var viewModel: CurrListViewModel
    private lateinit var category: String

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        arguments?.let {
            category = it.getString(CATEGORY_ARGUMENT)
        }

        return activity?.let {
            viewModel = ViewModelProviders.of(it).get(CurrListViewModel::class.java)
            AlertDialog.Builder(it).apply {
                setView(layoutInflater.inflate(R.layout.add_list_dialog, null))
                setPositiveButton(R.string.ok_btn) { _, _ -> positiveClick() }
                setNegativeButton(R.string.cancel_btn) { _, _ -> dialog.cancel() }

            }.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }

    private fun positiveClick(){
        val newList = ListEntity(new_list_name.text.toString(), category)
        GlobalScope.launch {
            viewModel.insert(newList)
        }
    }
}