package com.zalora.twitsplit.ui

import android.content.Context
import android.content.Intent
import com.zalora.twitsplit.util.Log
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
    val TAG = javaClass.name

    fun log(msg : String) {
        Log.d(TAG, msg)
    }
}