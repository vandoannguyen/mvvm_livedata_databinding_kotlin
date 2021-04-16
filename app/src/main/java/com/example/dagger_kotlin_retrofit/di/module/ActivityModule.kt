package com.example.dagger_kotlin_retrofit.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.di.scope.ActivityScope
import com.example.dagger_kotlin_retrofit.ui.main.MainViewModel
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
            BaseViewModelFactory<MainViewModel>(MainViewModel(iRepository))
        ).get(MainViewModel::class.java);
    }

    @Provides
    fun providerMain2ViewModel(iRepository: IRepository): Main2ViewModel {
        return ViewModelProvider(
            activity,
            BaseViewModelFactory<Main2ViewModel>(Main2ViewModel(iRepository))
        ).get(Main2ViewModel::class.java);
    }
}