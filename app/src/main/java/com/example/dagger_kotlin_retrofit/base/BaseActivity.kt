package com.example.dagger_kotlin_retrofit.base

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.BR
import com.example.dagger_kotlin_retrofit.common.DialogLoading
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.ui.main.MainViewModel


abstract class BaseActivity<VM : BaseViewModel, BD : ViewDataBinding> : AppCompatActivity() {
    val TAG: String = "BaseActivity";
    lateinit var viewModel: VM;
    lateinit var binding: BD;
    var layoutView: Int = -1;
    var dialogLoading: DialogLoading? = null;
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
    open fun initEventModel() {
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
            run {
                Log.e(TAG, "initEventModel: show$isLoading")

                if (isLoading) {
                    if (dialogLoading != null) dialogLoading?.dismiss();
                    dialogLoading = DialogLoading(this);
                    dialogLoading?.show();
                    Log.e(TAG, "initEventModel: show")
                } else {
                    dialogLoading?.dismiss();
                }
            }
        })
    };
    abstract fun createViewModel(): VM;

}