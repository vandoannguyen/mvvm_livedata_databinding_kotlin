package com.example.dagger_kotlin_retrofit.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel : ViewModel {
    @Inject
    constructor() : super() {
        initData();
    }

    private var compositeDisposable: CompositeDisposable = CompositeDisposable();
    lateinit var isLoading: MutableLiveData<Boolean>;
    lateinit var showMess: MutableLiveData<String>;
    lateinit var changeScreen: MutableLiveData<Class<*>>;
    open fun initData() {
        isLoading = MutableLiveData();
        showMess = MutableLiveData();
        changeScreen = MutableLiveData();
    }
    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable);
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose();
    }
}