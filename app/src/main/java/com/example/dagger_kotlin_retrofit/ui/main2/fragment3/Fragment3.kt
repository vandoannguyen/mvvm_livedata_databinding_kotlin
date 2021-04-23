package com.example.dagger_kotlin_retrofit.ui.main2.fragment3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.Fragment3Binding
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_3.*

@AndroidEntryPoint
class Fragment3 : BaseFragment<Fragment3ViewModel, Fragment3Binding>() {
    private val viewModel by viewModels<Fragment3ViewModel>()
    private val mainViewModel by activityViewModels<Main2ViewModel>();
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtClick.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment1);
        }
    }

    override val setContentLayout: Int = R.layout.fragment_3;

    override fun getVM(): Fragment3ViewModel = viewModel
}