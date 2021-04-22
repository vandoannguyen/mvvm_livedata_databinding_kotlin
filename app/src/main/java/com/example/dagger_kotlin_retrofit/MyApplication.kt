package com.example.dagger_kotlin_retrofit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

//    var applicationComponent: ApplicationComponent? = null;

    override fun onCreate() {
        super.onCreate()
//        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
//            ApplicationModule(this)
//        ).build();
//        applicationComponent?.inject(this);
    }
}