package com.example.dagger_kotlin_retrofit.ui.main2.fragment

import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.BlankFragmentBinding
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent

class BlankFragment : BaseFragment<BlankViewModel, BlankFragmentBinding>() {

    override fun initEventModel() {
        super.initEventModel()
    }

    override fun createContentView(): Int {
        return R.layout.blank_fragment;
    }

    override fun performDependencyInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this);
    }
}