package com.example.dagger_kotlin_retrofit.data.network

import io.reactivex.rxjava3.core.Single

interface IApiHelper {
    fun getData(): Single<String>;
    fun postData(): Single<String>;
}