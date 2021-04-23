package com.example.dagger_kotlin_retrofit.ui.main2.fragment3

import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class Fragment3ViewModel : BaseViewModel {
    var iRepository: IRepository;

    @Inject
    constructor(iRepository: IRepository) {
        this.iRepository = iRepository;
    }
}