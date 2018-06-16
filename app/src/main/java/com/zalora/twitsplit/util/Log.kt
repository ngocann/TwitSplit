package com.zalora.twitsplit.util

import android.util.Log

object Log {
    fun d ( msg : String) {
        d("nna", msg)
    }
    fun d(tag : String, msg : String) {
        Log.d(tag, msg)
    }
}