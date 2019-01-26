package com.example.yohai.mychecklist.currlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.R
import com.example.yohai.mychecklist.database.entities.CategoryEntity
import com.example.yohai.mychecklist.database.entities.ItemEntity
import com.example.yohai.mychecklist.database.entities.ListEntity
import kotlinx.android.synthetic.main.curr_list_fragment.*
import timber.log.Timber

class CurrList : Fragment() {

    companion object {
        fun newInstance() = CurrList()
    }

    private lateinit var viewModel: CurrListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.curr_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrListViewModel::class.java)

        fab.setOnClickListener {
            viewModel.insert(CategoryEntity("hello", listOf(ListEntity("world", listOf(ItemEntity("item 1"))))))
            Timber.d("Inserting new category")
        }

        viewModel.allCategories.observe(this, Observer<List<CategoryEntity>> {
            Timber.d("Categories has changed")
            Toast.makeText(activity,"curr db: $it",Toast.LENGTH_SHORT).show()
            Timber.d("curr DB $it")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
