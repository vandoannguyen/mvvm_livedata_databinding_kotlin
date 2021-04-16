package com.example.dagger_kotlin_retrofit.di.component

import com.example.dagger_kotlin_retrofit.di.module.FragmentModule
import com.example.dagger_kotlin_retrofit.di.scope.FragmentScope
import com.example.dagger_kotlin_retrofit.ui.main2.fragment.BlankFragment
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {
    fun inject(fragment: BlankFragment)
}