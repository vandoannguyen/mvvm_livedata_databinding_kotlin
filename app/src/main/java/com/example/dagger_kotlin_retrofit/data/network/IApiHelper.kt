package com.example.dagger_kotlin_retrofit.data.network

import com.example.dagger_kotlin_retrofit.data.mode.network.User
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiHelper {
    @GET("/users/{user}")
    fun getData(@Path("user") user: String?): Observable<User>

    @GET("/users")
    fun getUsers(): Observable<List<User>>
}