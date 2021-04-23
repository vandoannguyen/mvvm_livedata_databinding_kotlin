package com.example.dagger_kotlin_retrofit.ui.main2.fragment2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import com.example.dagger_kotlin_retrofit.ui.main2.fragment1.Fragment1ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Fragment2ViewModel @Inject constructor(private val iRepository: IRepository) :
    BaseViewModel() {
    lateinit var edtContent: MutableLiveData<String>;
    lateinit var backFragment: MutableLiveData<Void>;
    var main2ViewModel: Main2ViewModel? = null;
    fun setActivityViewModel(viewModel: ViewModel?) {
        this.main2ViewModel = viewModel as Main2ViewModel;
    }

    override fun initData() {
        super.initData()
        edtContent = MutableLiveData();
        backFragment = MutableLiveData();
    }

    fun clickSubmit() {
        backFragment.postValue(null);
        backFragment = MutableLiveData();
    }
}