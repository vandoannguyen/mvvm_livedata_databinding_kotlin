package com.example.dagger_kotlin_retrofit.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseViewModelFactory<T : ViewModel?> : ViewModelProvider.Factory {
    var viewModel: T;

    companion object {
        var mapViewModel: HashMap<String, ViewModel> = HashMap();
        fun addViewModel(key: String, viewModel: ViewModel?) {
            if (viewModel != null) {
                mapViewModel.put(key, viewModel)
            };
        }

        fun getViewModel(key: String): ViewModel? {
            return mapViewModel.get(key);
        }

        fun removeViewModel(viewModel: ViewModel) {
            mapViewModel.remove(viewModel.javaClass.name);
        }
    }

    constructor(viewModel: T) {
        this.viewModel = viewModel
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (getViewModel(modelClass.name) != null)
            return getViewModel(modelClass.name) as T;
        addViewModel(modelClass.name, this.viewModel);
        return viewModel as T;
    }
}