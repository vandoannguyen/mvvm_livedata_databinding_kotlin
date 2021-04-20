package com.example.dagger_kotlin_retrofit.di.module

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.ui.main2.fragment1.Fragment1ViewModel
import com.example.dagger_kotlin_retrofit.ui.main2.fragment2.Fragment2ViewModel
import com.example.dagger_kotlin_retrofit.ui.main2.fragment3.Fragment3ViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    private var baseFragment: BaseFragment<*, *>;

    constructor(baseFragment: BaseFragment<*, *>) {
        this.baseFragment = baseFragment;
    }

    @Provides
    fun providerBlankFragment1ViewModel(iRepository: IRepository): Fragment1ViewModel {
        return ViewModelProvider(
            baseFragment,
            BaseViewModelFactory<Fragment1ViewModel>(Fragment1ViewModel(iRepository))
        ).get(Fragment1ViewModel::class.java)
    }

    @Provides
    fun providerBlankFragment2ViewModel(iRepository: IRepository): Fragment2ViewModel {
        return ViewModelProvider(
            baseFragment,
            BaseViewModelFactory<Fragment2ViewModel>(Fragment2ViewModel(iRepository))
        ).get(Fragment2ViewModel::class.java)
    }

    @Provides
    fun providerBlankFragment3ViewModel(iRepository: IRepository): Fragment3ViewModel {
        return ViewModelProvider(
            baseFragment,
            BaseViewModelFactory<Fragment3ViewModel>(Fragment3ViewModel(iRepository))
        ).get(Fragment3ViewModel::class.java)
    }

    @Provides
    fun providerLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(baseFragment.activity)
    }
}
