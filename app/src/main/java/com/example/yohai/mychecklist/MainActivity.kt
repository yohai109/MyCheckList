package com.example.yohai.mychecklist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.yohai.mychecklist.currlist.CurrList
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CurrListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CurrListViewModel::class.java)
        viewModel.initRepo(application)

        Timber.d("Adding first Fragment")
        addFragment("firstFragment",R.id.fragment_holder){CurrList.newInstance()}
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
