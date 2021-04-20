package com.example.dagger_kotlin_retrofit.ui.main2.fragment1

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.FragmentFragmenet1Binding
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import kotlinx.android.synthetic.main.fragment_fragmenet1.*
import kotlinx.android.synthetic.main.item_note.*

class Fragment1 : BaseFragment<Fragment1ViewModel, FragmentFragmenet1Binding>() {
    var activityViewModel: Main2ViewModel? = null;
    override fun performDependencyInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this);
        activityViewModel = activity?.let { ViewModelProvider(it).get(Main2ViewModel::class.java) };
    }

    override fun createContentView(): Int {
        return R.layout.fragment_fragmenet1;
    }

    override fun initEventModel() {
        super.initEventModel()
        viewModel.changeFragment.observe(this, Observer {
            findNavController().navigate(it);
        })
        activityViewModel?.edtContent?.observe(
            this,
            Observer {
                contentFragmet1.text = it;
            })
    }
}