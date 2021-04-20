package com.example.dagger_kotlin_retrofit.di.component

import androidx.fragment.app.Fragment
import com.example.dagger_kotlin_retrofit.di.module.FragmentModule
import com.example.dagger_kotlin_retrofit.di.scope.FragmentScope
import com.example.dagger_kotlin_retrofit.ui.main2.fragment1.Fragment1
import com.example.dagger_kotlin_retrofit.ui.main2.fragment2.Fragment2
import com.example.dagger_kotlin_retrofit.ui.main2.fragment3.Fragment3
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {
    fun inject(fragment: Fragment1)
    fun inject(fragment: Fragment2)
    fun inject(fragment: Fragment3)
}