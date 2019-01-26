package com.example.yohai.mychecklist.currList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.R

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

        viewModel.getList("a")
    }

}
