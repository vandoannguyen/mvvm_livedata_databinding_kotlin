package com.example.dagger_kotlin_retrofit.di.component

import com.example.dagger_kotlin_retrofit.di.module.ActivityModule
import com.example.dagger_kotlin_retrofit.di.scope.ActivityScope
import com.example.dagger_kotlin_retrofit.ui.main.MainActivity
import com.example.dagger_kotlin_retrofit.ui.main2.MainActivity2
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: MainActivity2)
}