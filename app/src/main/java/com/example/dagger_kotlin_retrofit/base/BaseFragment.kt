package com.example.dagger_kotlin_retrofit.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.BR

abstract class BaseFragment<VM : BaseViewModel, BD : ViewDataBinding>() : Fragment() {
    lateinit var binding: BD;
    private val TAG = "BaseFragment";
    private lateinit var viewModel: VM;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = getVM();
        initDataBinding(inflater, container);
        return binding.root;
    }

    @get: LayoutRes
    abstract val setContentLayout: Int
    abstract fun getVM(): VM
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEventModel();
    }


    fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, setContentLayout, container, false);
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
    }

    open fun initEventModel() {
        viewModel.showMess.observe(viewLifecycleOwner, Observer { mess ->
            run {
                Toast.makeText(context, mess, Toast.LENGTH_SHORT);
            }
        })
        viewModel.changeScreen.observe(viewLifecycleOwner, Observer { screen ->
            run {
                startActivity(Intent(context, screen));
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            kotlin.run {
                Log.e(TAG, "initEventModel: ")
            }
        })
    }
}