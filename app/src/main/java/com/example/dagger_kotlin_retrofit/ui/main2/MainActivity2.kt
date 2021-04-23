package com.example.dagger_kotlin_retrofit.ui.main2

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.databinding.ActivityMain3Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity2 : BaseActivity<Main2ViewModel, ActivityMain3Binding>() {
    private val viewModel: Main2ViewModel by viewModels();
//    lateinit var mainViewModel by ;
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

    override val setContentLayout: Int = R.layout.activity_main3

    override fun getVM(): Main2ViewModel = viewModel;
}