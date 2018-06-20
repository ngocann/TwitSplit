package com.zalora.twitsplit.di

import android.arch.lifecycle.ViewModel
import com.zalora.twitsplit.ui.main.AddTwitActivity
import com.zalora.twitsplit.ui.main.MainActivity
import com.zalora.twitsplit.viewmodel.TwitViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import elcom.efarm.supervisor.di.ViewModelKey

@Module
internal abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(TwitViewModel::class)
    abstract fun bindTwitViewModel(viewModel: TwitViewModel): ViewModel

    @ContributesAndroidInjector
    internal abstract fun addTwitActivity(): AddTwitActivity
}
