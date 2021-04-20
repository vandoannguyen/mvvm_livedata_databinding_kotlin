package com.example.dagger_kotlin_retrofit.ui.main2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository

class Main2ViewModel : BaseViewModel {
    var iRepository: IRepository;
    lateinit var edtContent: MutableLiveData<String>;
    lateinit var submitContent: MutableLiveData<String>;

    constructor(iRepository: IRepository) : super() {
        this.iRepository = iRepository;
    }

    override fun initData() {
        super.initData()
        edtContent = MutableLiveData();
        submitContent = MutableLiveData();
    }

    fun setEdtValue(s: String) {
        edtContent.postValue(s);
    }

}