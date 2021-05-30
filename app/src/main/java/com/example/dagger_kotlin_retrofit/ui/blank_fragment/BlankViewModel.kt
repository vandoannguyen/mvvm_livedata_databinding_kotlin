package com.example.dagger_kotlin_retrofit.ui.blank_fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import java.util.*
import javax.inject.Inject

class BlankViewModel : BaseViewModel {
    val TAG: String = "BlankViewModel";
    var iRepository: IRepository;
    var dem: MutableLiveData<Int> = MutableLiveData();

    @Inject
    constructor(iRepository: IRepository) : super() {
        this.iRepository = iRepository
    }

    fun clickList() {
        Log.e(TAG, "clickList: ")
        dem.value = Calendar.getInstance().timeInMillis.toInt();
    }
}