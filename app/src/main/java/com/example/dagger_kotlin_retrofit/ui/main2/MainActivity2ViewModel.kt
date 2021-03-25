package com.example.dagger_kotlin_retrofit.ui.main2

import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.network.IRepository

class MainActivity2ViewModel : BaseViewModel {
    var iRepository: IRepository;
    lateinit var demo: MutableLiveData<String>;

    constructor(iRepository: IRepository) : super() {
        this.iRepository = iRepository;
    }

    override fun initData() {
        super.initData()
        demo = MutableLiveData();
    }
}