package com.example.dagger_kotlin_retrofit.ui.main2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.network.IRepository

class Main2ViewModelFactory : ViewModelProvider.Factory {
    var repositoryImpl: IRepository;

    constructor(repositoryImpl: IRepository) {
        this.repositoryImpl = repositoryImpl;
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivity2ViewModel::class.java!!)) {
            MainActivity2ViewModel(repositoryImpl) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}