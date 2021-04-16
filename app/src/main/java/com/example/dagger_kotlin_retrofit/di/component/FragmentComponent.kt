package com.example.dagger_kotlin_retrofit.di.component

import com.example.dagger_kotlin_retrofit.di.module.FragmentModule
import com.example.dagger_kotlin_retrofit.ui.main2.fragment.BlankFragment
import dagger.Component

@Component(modules = [FragmentModule ::class])
interface FragmentComponent {
    fun inject(fragment: BlankFragment)
}