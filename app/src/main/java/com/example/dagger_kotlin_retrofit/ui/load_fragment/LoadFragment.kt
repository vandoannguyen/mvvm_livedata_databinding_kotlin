package com.example.dagger_kotlin_retrofit.ui.load_fragment

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.FragmentLoadBinding
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent

class LoadFragment : BaseFragment<LoadFragmentViewModel, FragmentLoadBinding>() {

    override fun performDependencyInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this);
    }

    override fun createContentView(): Int {
        return R.layout.fragment_load;
    }

    override fun initEventModel() {
        super.initEventModel()
        viewModel.intentToBlank.observe(this, Observer {
            mainViewModel.showRate();
        })
        viewModel.showMess.observe(this, Observer {
            kotlin.run {
                Toast.makeText(context, "$it", Toast.LENGTH_LONG).show();
            }
        })
    }
}