package com.example.dagger_kotlin_retrofit.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {
    lateinit var viewModel: VM;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel();
        initDataBinding();
    }

    abstract fun initDataBinding();

    abstract fun createViewModel(): VM;
    open fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}