package com.example.dagger_kotlin_retrofit.base

import androidx.lifecycle.ViewModel
import com.example.dagger_kotlin_retrofit.utils.event_live_data.EventLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : ViewModel {
    constructor() : super() {
        initData();
    }

    private var compositeDisposable: CompositeDisposable = CompositeDisposable();
    lateinit var isLoading: EventLiveData<Boolean>;
    lateinit var showMess: EventLiveData<String>;
    lateinit var changeScreen: EventLiveData<Class<*>>;
    open fun initData() {
        isLoading = EventLiveData();
        showMess = EventLiveData();
        changeScreen = EventLiveData();
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable);
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose();
    }
}