package com.zalora.twitsplit.ui.main

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.zalora.twitsplit.R
import com.zalora.twitsplit.databinding.ActivityAddBinding
import com.zalora.twitsplit.ui.BaseActivity

class AddTwitActivity : BaseActivity() {

    companion object {
        fun start(context: Context){
            val intent = Intent(context, AddTwitActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAddBinding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        binding.executePendingBindings()

    }
}