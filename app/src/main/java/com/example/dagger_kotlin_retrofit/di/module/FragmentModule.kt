package com.example.dagger_kotlin_retrofit.di.module

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.ui.main.MainViewModel
import com.example.dagger_kotlin_retrofit.ui.main2.fragment.BlankFragment
import com.example.dagger_kotlin_retrofit.ui.main2.fragment.BlankViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    private var baseFragment: BaseFragment<*, *>;

    constructor(baseFragment: BaseFragment<*, *>) {
        this.baseFragment = baseFragment;
    }

    @Provides
    fun providerBlankFragmentViewModel(iRepository: IRepository): BlankViewModel {
        return ViewModelProvider(
            baseFragment,
            BaseViewModelFactory<BlankViewModel>(BlankViewModel(iRepository))
        ).get(BlankViewModel::class.java)
    }

    @Provides
    fun providerLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(baseFragment.activity)
    }
}
