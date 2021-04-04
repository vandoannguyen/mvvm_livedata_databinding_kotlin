package com.example.dagger_kotlin_retrofit.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.dagger_kotlin_retrofit.BR


abstract class BaseActivity<VM : BaseViewModel, BD : ViewDataBinding> : AppCompatActivity() {
    lateinit var viewModel: VM;
    lateinit var binding: BD;
    var layoutView: Int = -1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel();
        initDataBinding();
        initEventModel();
    }


    fun initDataBinding() {
        layoutView = setContentLayout();
        binding = DataBindingUtil.setContentView(this, this.layoutView);
        binding.lifecycleOwner = this;
        binding.setVariable(BR.viewModel, viewModel);
    }

    open fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

    abstract fun setContentLayout(): Int;
    abstract fun initEventModel();
    abstract fun createViewModel(): VM;

}