package com.example.dagger_kotlin_retrofit.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel {
    constructor() : super() {
        initData();
    }

    lateinit var isLoading: MutableLiveData<Boolean>;
    lateinit var showMess: MutableLiveData<String>;
    open fun initData() {
        isLoading = MutableLiveData();
        showMess = MutableLiveData();
    }
}