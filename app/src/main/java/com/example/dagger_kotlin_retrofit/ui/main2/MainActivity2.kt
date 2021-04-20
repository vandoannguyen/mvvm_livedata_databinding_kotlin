package com.example.dagger_kotlin_retrofit.ui.main2

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.databinding.ActivityMain3Binding
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.di.component.ActivityComponent
import com.example.dagger_kotlin_retrofit.ui.main.MainViewModel
import javax.inject.Inject

class MainActivity2 : BaseActivity<Main2ViewModel, ActivityMain3Binding>() {

    @Inject
    lateinit var mainViewModel: Main2ViewModel;
    override fun setContentLayout(): Int {
        return R.layout.activity_main3;
    }

    override fun initEventModel() {
        super.initEventModel()
        viewModel.submitContent.observe(this, Observer {
//            mainViewModel.postSubmit(it);
            finish();
        })
    }

    override fun performDependencyInjection(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}