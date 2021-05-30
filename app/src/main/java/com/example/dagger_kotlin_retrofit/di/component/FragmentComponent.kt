package com.example.dagger_kotlin_retrofit.di.component

import com.example.dagger_kotlin_retrofit.di.module.FragmentModule
import com.example.dagger_kotlin_retrofit.di.scope.FragmentScope
import com.example.dagger_kotlin_retrofit.ui.blank_fragment.BlankFragment
import com.example.dagger_kotlin_retrofit.ui.load_fragment.LoadFragment
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {
    fun inject(fragment: BlankFragment)
    fun inject(fragment: LoadFragment)
}