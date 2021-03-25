package com.example.dagger_kotlin_retrofit.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel {
    constructor() : super() {
        initData();
    }

    var compositeDisposable: CompositeDisposable = CompositeDisposable();
    lateinit var isLoading: MutableLiveData<Boolean>;
    lateinit var showMess: MutableLiveData<String>;
    lateinit var changeScreen: MutableLiveData<Class<*>>;
    open fun initData() {
        isLoading = MutableLiveData();
        showMess = MutableLiveData();
        changeScreen = MutableLiveData();
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose();
    }
}