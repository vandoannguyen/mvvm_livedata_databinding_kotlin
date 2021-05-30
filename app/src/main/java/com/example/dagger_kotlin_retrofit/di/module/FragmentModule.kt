package com.example.dagger_kotlin_retrofit.di.module

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.ui.blank_fragment.BlankViewModel
import com.example.dagger_kotlin_retrofit.ui.load_fragment.LoadFragment
import com.example.dagger_kotlin_retrofit.ui.load_fragment.LoadFragmentViewModel
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
    fun providerLoadFragment(iRepository: IRepository):LoadFragmentViewModel{
        return ViewModelProvider(
            baseFragment,
            BaseViewModelFactory<LoadFragmentViewModel>(LoadFragmentViewModel(iRepository))
        ).get(LoadFragmentViewModel::class.java)
    }

    @Provides
    fun providerLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(baseFragment.activity)
    }
}
