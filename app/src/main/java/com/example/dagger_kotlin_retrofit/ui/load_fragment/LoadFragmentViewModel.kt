package com.example.dagger_kotlin_retrofit.ui.load_fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.utils.event_live_data.EventLiveData
import javax.inject.Inject

class LoadFragmentViewModel : BaseViewModel {
    var iRepository: IRepository;
    var intentToBlank: EventLiveData<Void> = EventLiveData<Void>();

    @Inject
    constructor(iRepository: IRepository) : super() {
        this.iRepository = iRepository
    }

    fun clickMe() {
        intentToBlank.postValue(null);

    }

    fun clickToast() {
        showMess.postValue("value toast");
    }
}
