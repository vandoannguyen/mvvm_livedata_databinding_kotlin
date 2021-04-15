package com.example.dagger_kotlin_retrofit.ui.main

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.base.BaseViewModelFactory
import com.example.dagger_kotlin_retrofit.databinding.ActivityMainBinding
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private lateinit var loadDialog: ProgressDialog;
    private var list: List<User> = ArrayList();
    private lateinit var adapter: TestAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG11111", "onCreate: ")
        initRecyclerView();
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = TestAdapter(list);
        recyclerView.adapter = adapter;
    }

    override fun createViewModel(): MainViewModel {
        var repositoryImpl: RepositoryImpl = RepositoryImpl.getInstance(applicationContext);
        return ViewModelProvider(
            this,
            BaseViewModelFactory<MainViewModel>(MainViewModel(repositoryImpl))
        ).get(MainViewModel::class.java);
    }

    override fun setContentLayout(): Int {
        return R.layout.activity_main;
    }

    override fun initEventModel() {
        super.initEventModel()
        viewModel.listUser.observe(this, {
            list = it;
            run {
                adapter.setList(list);
            }
        })
    }
}