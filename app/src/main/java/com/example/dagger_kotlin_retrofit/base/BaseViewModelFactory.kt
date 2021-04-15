package com.example.dagger_kotlin_retrofit.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseViewModelFactory<T : ViewModel?> : ViewModelProvider.Factory {
    var viewModel: T;

    constructor(viewModel: T) {
        this.viewModel = viewModel
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return this.viewModel as T;
    }
}