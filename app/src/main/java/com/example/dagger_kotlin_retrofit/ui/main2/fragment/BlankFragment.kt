package com.example.dagger_kotlin_retrofit.ui.main2.fragment

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.BlankFragmentBinding

class BlankFragment : BaseFragment<BlankViewModel, BlankFragmentBinding>() {

    override fun createViewModel(): BlankViewModel {
        return ViewModelProviders.of(this).get(BlankViewModel::class.java)
    }

    override fun initEventModel() {
        viewModel.showMess.observe(this, { mess ->
            run {
                Toast.makeText(context, mess, Toast.LENGTH_SHORT);
            }
        })
        viewModel.changeScreen.observe(this, { screen ->
            run {
                startActivity(Intent(context, screen));
            }
        })
        viewModel.isLoading.observe(this, { isLoading ->
            kotlin.run {

            }
        })
    }

    override fun getContentView(): Int {
        return R.layout.blank_fragment;
    }
}