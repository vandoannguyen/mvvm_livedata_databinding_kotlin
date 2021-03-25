package com.example.dagger_kotlin_retrofit.ui.main2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.databinding.ActivityMain3Binding
import com.example.dagger_kotlin_retrofit.network.IRepository
import com.example.dagger_kotlin_retrofit.network.RepositoryImpl

class MainActivity2 : BaseActivity<MainActivity2ViewModel>() {
    lateinit var binding: ActivityMain3Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel();
    }

    private fun initViewModel() {
        viewModel.changeScreen.observe(this, Observer { screen ->
            run {
                startActivity(Intent(this, screen));
            }
        })
        viewModel.showMess.observe(this, Observer { mess ->
            run {
                Toast.makeText(this, mess, Toast.LENGTH_SHORT);
            }
        })
        viewModel.isLoading.observe(this, Observer { isLoading ->
            kotlin.run {

            }
        })
    }

    override fun initDataBinding() {
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main3
        )
        binding.lifecycleOwner = this;
        binding.viewModel = viewModel;
    }

    override fun createViewModel(): MainActivity2ViewModel {
        var iRepositoryImpl: IRepository = RepositoryImpl();
        var main2ViewModelFactory: Main2ViewModelFactory = Main2ViewModelFactory(iRepositoryImpl);
        return ViewModelProvider(
            this,
            main2ViewModelFactory
        ).get(MainActivity2ViewModel::class.java);
    }
}