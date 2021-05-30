package com.example.dagger_kotlin_retrofit.ui

import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.utils.event_live_data.EventLiveData
import javax.inject.Inject

class MainViewModel : BaseViewModel {
    private val TAG: String = "MainViewModel";

    var repositoryImpl: IRepository;
    var dem: MutableLiveData<String> = MutableLiveData();
    var showRateDialog: EventLiveData<Void> = EventLiveData();

    @Inject
    constructor(repositoryImpl: IRepository) : super() {
        this.repositoryImpl = repositoryImpl
    }

    fun showRate() {
        showRateDialog.postValue(null);
    }

    override fun initData() {
        super.initData()
    }

    fun clickButton() {
        showRateDialog.postValue(null);
    }
}