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
import com.example.dagger_kotlin_retrofit.databinding.ActivityMainBinding
import com.example.dagger_kotlin_retrofit.network.RepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private lateinit var loadDialog: ProgressDialog;
    private var list: List<String> = arrayListOf("1", "2", "3", "4", "5");
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
        var repositoryImpl: RepositoryImpl = RepositoryImpl.getInstance();
        var mainViewModelFactory = MainViewModelFactory(repositoryImpl);
        return ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java);
    }

    override fun setContentLayout(): Int {
        return R.layout.activity_main;
    }

    override fun initEventModel() {
        viewModel.isLoading.observe(this, { isLoading ->
            run {
                if (isLoading) {
                    loadDialog = ProgressDialog(this);
                    loadDialog.show();
                } else {
                    loadDialog.dismiss();
                }
            }
        });
        viewModel.showMess.observe(
            this, { mess ->
                run {
                    Log.e("MAIN1", "initViewModel: ");
                    Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
                }
            }
        )
        viewModel.changeScreen.observe(this, Observer { screen ->
            run {
                startActivity(Intent(this@MainActivity, screen));
            }
        }
        );
    }
}