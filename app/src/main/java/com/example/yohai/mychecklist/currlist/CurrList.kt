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
        // TODO: Use the ViewModel

        viewModel.allCategories.observe(this, Observer<List<CategoryEntity>> {
            // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Timber.d("Categories has changed")
            Toast.makeText(activity,"Categories has changed",Toast.LENGTH_SHORT).show()
        })
    }

}
