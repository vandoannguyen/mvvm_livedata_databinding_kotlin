package com.example.dagger_kotlin_retrofit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_kotlin_retrofit.network.IRepository
import com.example.dagger_kotlin_retrofit.network.RepositoryImpl


class MainViewModelFactory : ViewModelProvider.Factory {
    var repositoryImpl: IRepository;

    constructor(repositoryImpl: RepositoryImpl) {
        this.repositoryImpl = repositoryImpl;
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            MainViewModel(repositoryImpl) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}