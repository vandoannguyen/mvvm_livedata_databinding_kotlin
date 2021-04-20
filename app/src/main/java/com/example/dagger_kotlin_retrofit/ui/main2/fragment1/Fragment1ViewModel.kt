package com.example.dagger_kotlin_retrofit.ui.main2.fragment1

import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import javax.inject.Inject

class Fragment1ViewModel : BaseViewModel {
    var iRepository: IRepository;
    lateinit var contentText: MutableLiveData<String>;
    lateinit var changeFragment: MutableLiveData<Int>;

    @Inject
    constructor(iRepository: IRepository) {
        this.iRepository = iRepository;
    }

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