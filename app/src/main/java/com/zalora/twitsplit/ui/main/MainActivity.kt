package com.zalora.twitsplit.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.zalora.twitsplit.R
import com.zalora.twitsplit.adapter.TwitAdapter
import com.zalora.twitsplit.databinding.ActivityMainBinding
import com.zalora.twitsplit.ui.BaseActivity
import com.zalora.twitsplit.viewmodel.TwitViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val twitAdapter = TwitAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.executePendingBindings()
        binding.rvTwit.layoutManager = LinearLayoutManager(this)
        binding.rvTwit.adapter = twitAdapter
        val twitViewModel = ViewModelProviders.of(this, viewModelFactory).get(TwitViewModel::class.java)
        twitViewModel.getTwits().observe(this, Observer {
            it?.let {
                log("list twit ${it.size}")
                twitAdapter.setNewData(it)
            }
        })

        fabAddTwit.setOnClickListener {
            AddTwitActivity.start(this)
        }




    }


}
