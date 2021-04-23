package com.example.dagger_kotlin_retrofit.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import com.example.dagger_kotlin_retrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private var list: List<User> = ArrayList();
    private lateinit var adapter: TestAdapter;
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView();
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = TestAdapter(list);
        recyclerView.adapter = adapter;
    }


    override fun setContentLayout(): Int {
        return R.layout.activity_main;
    }

    override fun initEventModel() {
        super.initEventModel()
        viewModel.listUser.observe(this, Observer {
            list = it;
            run {
                adapter.setList(list);
            }
        })
    }

    override fun getVM(): MainViewModel {
        return viewModel;
    }

    override val setContentLayout: Int = R.layout.activity_main

}