package com.example.dagger_kotlin_retrofit.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.ui.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    private var activity: BaseActivity<*, *>;

    constructor(baseActivity: BaseActivity<*, *>) {
        this.activity = baseActivity;
    }

    @Provides
    fun providerMainViewModel(iRepository: IRepository): MainViewModel {
        return ViewModelProvider(
            activity,
            BaseViewModelFactory<MainViewModel>(
                MainViewModel(iRepository)
            )
        ).get(MainViewModel::class.java);
    }
}