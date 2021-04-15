package com.example.dagger_kotlin_retrofit.ui.main2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.databinding.ActivityMain3Binding
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl

class MainActivity2 : BaseActivity<MainActivity2ViewModel, ActivityMain3Binding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun createViewModel(): MainActivity2ViewModel {
        var iRepositoryImpl: IRepository = RepositoryImpl.getInstance(applicationContext);
        return ViewModelProvider(
            this,
            BaseViewModelFactory<MainActivity2ViewModel>(MainActivity2ViewModel(iRepositoryImpl))
        ).get(MainActivity2ViewModel::class.java);
    }

    override fun setContentLayout(): Int {
        return R.layout.activity_main3;
    }

    override fun initEventModel() {
        super.initEventModel()
    }
}