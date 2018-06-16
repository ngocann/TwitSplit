package com.zalora.twitsplit.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zalora.twitsplit.R
import com.zalora.twitsplit.model.Twit
import com.zalora.twitsplit.viewmodel.TwitViewModel
import com.zalora.twitsplit.viewmodel.TwitViewModel_Factory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val twitViewModel = ViewModelProviders.of(this, viewModelFactory).get(TwitViewModel::class.java)
        twitViewModel.getTwits().observe(this, Observer {
            it?.let { log("list twit ${it.size}") }
        })

        btnAdd.setOnClickListener {
            twitViewModel.insertTwit(Twit(null, "test", Calendar.getInstance().timeInMillis))
        }

    }


}
