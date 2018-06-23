package com.zalora.twitsplit.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.zalora.twitsplit.model.Twit
import com.zalora.twitsplit.repository.TwitRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TwitViewModel @Inject constructor(private val twitRepository: TwitRepository) : ViewModel() {

    private val twitLiveData : LiveData<List<Twit>> = LiveDataReactiveStreams.fromPublisher(twitRepository.getMessages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    )

    fun getTwits() : LiveData<List<Twit>> {
        return twitLiveData
    }

    fun insertTwit(twit: Twit) {
        twitRepository.insertTwit(twit)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {  }
    }

}