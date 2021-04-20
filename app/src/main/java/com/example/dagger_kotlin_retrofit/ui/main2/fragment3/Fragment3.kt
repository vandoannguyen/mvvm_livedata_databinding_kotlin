package com.example.dagger_kotlin_retrofit.ui.main2.fragment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseFragment
import com.example.dagger_kotlin_retrofit.databinding.Fragment3Binding
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent
import kotlinx.android.synthetic.main.fragment_3.*

class Fragment3 : BaseFragment<Fragment3ViewModel, Fragment3Binding>() {
    override fun performDependencyInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this);
    }

    override fun createContentView(): Int {
        return R.layout.fragment_3;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtClick.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment1);
        }
    }
}