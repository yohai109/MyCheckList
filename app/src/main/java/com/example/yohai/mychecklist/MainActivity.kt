package com.example.yohai.mychecklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.yohai.mychecklist.currList.CurrList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment("firstFragment",R.id.fragment_holder){CurrList.newInstance()}
    }
}

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
