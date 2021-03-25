package com.example.dagger_kotlin_retrofit.network.api

import io.reactivex.rxjava3.core.Single
import java.util.*

class ApiHelperImpl : IApiHelper {
    override fun getData(): Single<String> {
        return Single.just(Calendar.getInstance().timeInMillis.toString());
    }

    override fun postData(): Single<String> {
        TODO("Not yet implemented")
    }
}