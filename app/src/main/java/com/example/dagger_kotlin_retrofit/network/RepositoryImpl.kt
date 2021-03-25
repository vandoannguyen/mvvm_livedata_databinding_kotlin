package com.example.dagger_kotlin_retrofit.network

import com.example.dagger_kotlin_retrofit.network.api.ApiHelperImpl
import com.example.dagger_kotlin_retrofit.network.api.IApiHelper
import io.reactivex.rxjava3.core.Single

class RepositoryImpl : IRepository {
    companion object {
        private var INSTANCE: RepositoryImpl? = null;
        fun getInstance(): RepositoryImpl {
            return INSTANCE ?: RepositoryImpl();
        }
    }

    var api: IApiHelper;

    constructor() {
        api = ApiHelperImpl();
    }

    override fun getData(): Single<String> {
        return api.getData();
    }

    override fun postData(): Single<String> {
        TODO("Not yet implemented")
    }
}