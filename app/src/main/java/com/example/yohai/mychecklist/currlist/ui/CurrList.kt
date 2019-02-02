package com.example.yohai.mychecklist.currlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.R
import com.example.yohai.mychecklist.currlist.viewmodel.CurrListViewModel
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ListEntity
import com.example.yohai.mychecklist.newlistdialog.NewListDialog
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.add_list_dialog.*
import kotlinx.android.synthetic.main.curr_list_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class CurrList : Fragment() {

    lateinit var viewModel: CurrListViewModel
    private lateinit var category: String


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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.curr_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            AndroidInjection.inject(it)
            viewModel = ViewModelProviders.of(it).get(CurrListViewModel::class.java)
        }

        arguments?.let {
            category = it.getString(CurrList.CATEGORY_ARGUMENT,"")
        }

        fab.setOnClickListener { fabClick() }

        viewModel.allCategories?.observe(this, Observer<List<CategoryEntity>> {
            Timber.d("Categories has changed")
            Timber.i("$it")
            Toast.makeText(activity,"Categories has changed", Toast.LENGTH_SHORT).show()
        })
    }

    private fun fabClick() {
        Timber.d("Clicked on fab")
        context?.let { NewListDialog.newInstance(category).dialog.show() }
    }
}
