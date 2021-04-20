package com.example.dagger_kotlin_retrofit.ui.main2.fragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.Fragment2Binding
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import javax.inject.Inject

class Fragment2 : BaseFragment<Fragment2ViewModel, Fragment2Binding>() {
    var activityViewModel: Main2ViewModel? = null;
    override fun performDependencyInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this);
        activityViewModel = activity?.let { ViewModelProvider(it).get(Main2ViewModel::class.java) };
    }

    override fun createContentView(): Int {
        return R.layout.fragment_2
    }

    override fun initEventModel() {
        super.initEventModel()
        viewModel.backFragment.observe(this, Observer {
            viewModel.edtContent.value?.let { it1 -> activityViewModel?.setEdtValue(it1) };
            findNavController().navigate(R.id.action_fragment2_to_fragment3);
        })
    }
}