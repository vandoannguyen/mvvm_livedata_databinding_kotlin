package com.example.dagger_kotlin_retrofit.ui.main2.load_data

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.FragmentFragmenet1Binding
import com.example.dagger_kotlin_retrofit.ui.main2.Main2ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_fragmenet1.*
@AndroidEntryPoint
class LoadActivity : BaseFragment<LoadViewModel, FragmentFragmenet1Binding>() {
    private val viewModel by viewModels<LoadViewModel>();
    private val activityViewModel by activityViewModels<Main2ViewModel>();
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

    override fun getVM(): LoadViewModel = viewModel

    override val setContentLayout: Int = R.layout.fragment_fragmenet1;
}