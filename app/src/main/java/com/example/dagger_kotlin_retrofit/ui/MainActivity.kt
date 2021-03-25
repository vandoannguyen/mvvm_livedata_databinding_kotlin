package com.example.dagger_kotlin_retrofit.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.databinding.ActivityMainBinding
import com.example.dagger_kotlin_retrofit.network.RepositoryImpl

class MainActivity : BaseActivity<MainViewModel>() {
    lateinit var loadDialog: ProgressDialog;
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel();
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(this, Observer { isLoading ->
            run {
                if (isLoading) {
                    loadDialog = ProgressDialog(this);
                    loadDialog.show();
                } else {
//                    if (loadDialog != null) {
                    loadDialog.dismiss();
//                    }
                }
            }
        });
        viewModel.showMess.observe(
            this, Observer { mess ->
                run {
                    Log.e("MAIN1", "initViewModel: ");
                    Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun createViewModel(): MainViewModel {
        var repositoryImpl: RepositoryImpl = RepositoryImpl.getInstance();
        var mainViewModelFactory = MainViewModelFactory(repositoryImpl);
        return ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java);
    }

    override fun initDataBinding() {
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.lifecycleOwner = this;
        binding.viewModel = viewModel;
    }

}