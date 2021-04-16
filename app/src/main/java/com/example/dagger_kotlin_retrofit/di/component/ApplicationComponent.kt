package com.example.dagger_kotlin_retrofit.di.component

import com.example.dagger_kotlin_retrofit.MyApplication
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.di.module.ApplicationModule
import com.example.dagger_kotlin_retrofit.ui.main.MainActivity
import com.example.dagger_kotlin_retrofit.ui.main2.MainActivity2
import com.example.dagger_kotlin_retrofit.ui.main2.fragment.BlankFragment
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: MyApplication);
    fun getRepository(): IRepository;
}