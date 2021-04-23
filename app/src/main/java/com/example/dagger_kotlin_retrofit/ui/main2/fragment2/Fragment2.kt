package com.example.dagger_kotlin_retrofit.ui.main2.fragment2

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.Fragment2Binding
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Fragment2 : BaseFragment<Fragment2ViewModel, Fragment2Binding>() {
    private val viewModel by viewModels<Fragment2ViewModel>()
    private val activityViewModel by activityViewModels<Main2ViewModel>();

    override fun initEventModel() {
        super.initEventModel()
        viewModel.backFragment.observe(this, Observer {
            viewModel.edtContent.value?.let { it1 -> activityViewModel?.setEdtValue(it1) };
            findNavController().navigate(R.id.action_fragment2_to_fragment3);
        })
    }

    override fun getVM(): Fragment2ViewModel {
        return viewModel;
    }

    override val setContentLayout: Int = R.layout.fragment_2;
}