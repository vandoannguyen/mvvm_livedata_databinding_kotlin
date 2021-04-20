package com.example.dagger_kotlin_retrofit.ui.main2.fragment3

import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import javax.inject.Inject

class Fragment3ViewModel : BaseViewModel {
    var iRepository: IRepository;

    @Inject
    constructor(iRepository: IRepository) {
        this.iRepository = iRepository;
    }
}