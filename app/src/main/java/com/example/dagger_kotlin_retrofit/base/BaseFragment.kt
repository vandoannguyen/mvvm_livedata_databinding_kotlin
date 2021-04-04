package com.example.dagger_kotlin_retrofit.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.dagger_kotlin_retrofit.BR

abstract class BaseFragment<VM : ViewModel, BD : ViewDataBinding>() : Fragment() {
    lateinit var binding: BD;
    lateinit var viewModel: VM;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel();
    }

    abstract fun createViewModel(): VM;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initDataBinding(inflater, container);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEventModel();
    }


    fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getContentView(), container, false);
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
    }

    abstract fun initEventModel();
    abstract fun getContentView(): Int;
}