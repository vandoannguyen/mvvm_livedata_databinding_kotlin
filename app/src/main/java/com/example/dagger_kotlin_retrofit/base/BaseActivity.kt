package com.example.dagger_kotlin_retrofit.base

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.BR
import com.example.dagger_kotlin_retrofit.MyApplication
import com.example.dagger_kotlin_retrofit.common.DialogLoading
import com.example.dagger_kotlin_retrofit.di.component.ActivityComponent
import com.example.dagger_kotlin_retrofit.di.component.DaggerActivityComponent
import com.example.dagger_kotlin_retrofit.di.module.ActivityModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity<VM : BaseViewModel, BD : ViewDataBinding> : AppCompatActivity() {
    val TAG: String = "BaseActivity";
    var viewModel: VM by viewModels<VM>();
    lateinit var binding: BD;
    var layoutView: Int = -1;
    var dialogLoading: DialogLoading? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection(getActivityComponent());
        super.onCreate(savedInstanceState)
        initDataBinding();
        initEventModel();
    }

    override fun onResume() {
        super.onResume()
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
                Log.e(TAG, "initEventModel:changeScreen ")
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
    private fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build();
    }

    abstract fun performDependencyInjection(activityComponent: ActivityComponent);
    override fun onDestroy() {
        super.onDestroy()
        BaseViewModelFactory.removeViewModel(viewModel)
    }
}