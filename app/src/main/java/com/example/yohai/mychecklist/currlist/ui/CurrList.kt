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
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.add_list_dialog.*
import kotlinx.android.synthetic.main.curr_list_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class CurrList : Fragment() {

    lateinit var viewModel: CurrListViewModel

    companion object {
        fun newInstance() = CurrList()
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

        fab.setOnClickListener { fabClick(it) }

        viewModel.allCategories?.observe(this, Observer<List<CategoryEntity>> {
            Timber.d("Categories has changed")
            Timber.i("$it")
            Toast.makeText(activity,"Categories has changed", Toast.LENGTH_SHORT).show()
        })
    }

    private fun fabClick(v: View?) {
        Timber.d("Clicked on fab")
        context?.let {
//            val dialog = AlertDialog
//                    .Builder(it)
//                    .setView(R.layout.add_list_dialog)
//                    .create()
//
//            ok_btn.setOnClickListener{
//                val newList = if (viewModel.allCategories?.value.isNullOrEmpty()) {
//                    GlobalScope.launch {
//                        viewModel.insert(CategoryEntity("new category"))
//                    }
//                    ListEntity(new_list_name.text.toString(),"new category")
//                } else {
//                    ListEntity(new_list_name.text.toString(), viewModel.allCategories!!.value!![0].categoryName)
//                }
//
//                GlobalScope.launch {
//                    viewModel.insert(newList)
//                }
//            }
//
//            dialog.show()
        }
    }
}
