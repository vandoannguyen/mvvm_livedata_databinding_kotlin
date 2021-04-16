package com.example.dagger_kotlin_retrofit.ui.main2

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.databinding.ActivityMain3Binding
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.di.component.ActivityComponent

class MainActivity2 : BaseActivity<Main2ViewModel, ActivityMain3Binding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun setContentLayout(): Int {
        return R.layout.activity_main3;
    }

    override fun initEventModel() {
        super.initEventModel()
    }

    override fun performDependencyInjection(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}