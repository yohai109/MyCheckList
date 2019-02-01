package com.example.yohai.mychecklist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.currlist.ui.CurrList
import com.example.yohai.mychecklist.currlist.viewmodel.CurrListViewModel
import com.example.yohai.mychecklist.currlist.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var factory: ViewModelFactory
    lateinit var viewModel: CurrListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, factory).get(CurrListViewModel::class.java)

        Timber.d("Adding first Fragment")
        addFragment("firstFragment",R.id.fragment_holder){ CurrList.newInstance()}
    }
}

/**
 * This function adds a fragment
 */
fun AppCompatActivity.addFragment(tag: String, layoutId: Int, allowStateLoss: Boolean = false,
                                  newInstance: () -> Fragment) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance()
    val transaction = supportFragmentManager.beginTransaction()
            .replace(layoutId, fragment, tag)
    if (allowStateLoss) {
        transaction.commitAllowingStateLoss()
    } else {
        transaction.commit()
    }
}
