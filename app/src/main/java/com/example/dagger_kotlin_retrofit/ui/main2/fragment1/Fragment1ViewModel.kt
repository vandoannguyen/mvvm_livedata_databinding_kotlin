package com.example.dagger_kotlin_retrofit.ui.main2.fragment1

import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Fragment1ViewModel @Inject constructor(private val iRepository: IRepository) :
    BaseViewModel() {
    lateinit var contentText: MutableLiveData<String>;
    lateinit var changeFragment: MutableLiveData<Int>;

    override fun initData() {
        super.initData()
        contentText = MutableLiveData();
        changeFragment = MutableLiveData();
    }

    fun clickMe() {
        changeFragment.postValue(R.id.action_fragment1_to_fragment2);
        changeFragment = MutableLiveData();
    }
}