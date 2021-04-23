package com.example.dagger_kotlin_retrofit.data.network

import com.example.dagger_kotlin_retrofit.data.mode.network.User
import com.example.dagger_kotlin_retrofit.data.network.provider.RetrofitClient
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class ApiHelperImpl : IApiHelper {
    lateinit var client: Retrofit;
    lateinit var apiHelper: IApiHelper;
    @Inject
    constructor() {
        client = RetrofitClient.getClient("https://api.github.com")!!
        apiHelper = client.create(IApiHelper::class.java)
    }

    override fun getData(user: String?): Observable<User> {
        return apiHelper.getData(user);
    }

    override fun getUsers(): Observable<List<User>> {
        return apiHelper.getUsers();
    }
}