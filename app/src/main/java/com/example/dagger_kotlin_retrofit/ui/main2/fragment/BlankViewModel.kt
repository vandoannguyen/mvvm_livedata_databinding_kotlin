package com.example.dagger_kotlin_retrofit.ui.main2.fragment

import androidx.lifecycle.ViewModel
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import javax.inject.Inject

class BlankViewModel : BaseViewModel {
    lateinit var iRepository: IRepository;

    @Inject
    constructor(iRepository: IRepository) {
        this.iRepository = iRepository;
    }
}