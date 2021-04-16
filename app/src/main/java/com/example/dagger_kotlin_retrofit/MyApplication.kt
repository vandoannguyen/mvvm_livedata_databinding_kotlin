package com.example.dagger_kotlin_retrofit

import android.app.Application
import com.example.dagger_kotlin_retrofit.di.component.ApplicationComponent
import com.example.dagger_kotlin_retrofit.di.component.DaggerApplicationComponent
import com.example.dagger_kotlin_retrofit.di.module.ApplicationModule


class MyApplication : Application() {

    var applicationComponent: ApplicationComponent? = null;

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build();
        applicationComponent?.inject(this);
    }
}