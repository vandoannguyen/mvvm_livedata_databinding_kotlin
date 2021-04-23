package com.example.dagger_kotlin_retrofit.ui.main2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Main2ViewModel @Inject constructor(private val iRepository: IRepository) : BaseViewModel() {
    lateinit var edtContent: MutableLiveData<String>;
    lateinit var submitContent: MutableLiveData<String>;


    override fun initData() {
        super.initData()
        edtContent = MutableLiveData();
        submitContent = MutableLiveData();
    }

    fun setEdtValue(s: String) {
        edtContent.postValue(s);
    }

}