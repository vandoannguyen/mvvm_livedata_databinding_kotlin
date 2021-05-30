package com.example.dagger_kotlin_retrofit.ui.blank_fragment

import android.util.Log
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.BlankFragmentBinding
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent
import kotlinx.android.synthetic.main.blank_fragment.*

class BlankFragment : BaseFragment<BlankViewModel, BlankFragmentBinding>() {
val TAG:String ="BlankFragment";
    override fun createContentView(): Int {
        return R.layout.blank_fragment;
    }

    override fun performDependencyInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this);
    }

    override fun initEventModel() {
        super.initEventModel()
    }
}