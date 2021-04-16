package com.example.dagger_kotlin_retrofit.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.BR
import com.example.dagger_kotlin_retrofit.MyApplication
import com.example.dagger_kotlin_retrofit.di.component.DaggerFragmentComponent
import com.example.dagger_kotlin_retrofit.di.component.FragmentComponent
import com.example.dagger_kotlin_retrofit.di.module.FragmentModule
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, BD : ViewDataBinding>() : Fragment() {
    lateinit var binding: BD;

    @Inject
    lateinit var viewModel: VM;
    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection(getFragmentComponent());
        super.onCreate(savedInstanceState)
    }

    abstract fun performDependencyInjection(fragmentComponent: FragmentComponent)

    private fun getFragmentComponent(): FragmentComponent {
        return DaggerFragmentComponent.builder()
            .applicationComponent((activity?.application as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build();
    }

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
        binding = DataBindingUtil.inflate(inflater, createContentView(), container, false);
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

            }
        })
    }

    abstract fun createContentView(): Int;
}