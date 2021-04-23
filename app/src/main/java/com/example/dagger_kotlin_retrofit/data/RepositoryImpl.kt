package com.example.dagger_kotlin_retrofit.data

import android.content.Context
import com.example.dagger_kotlin_retrofit.data.local.ILocalDataHelper
import com.example.dagger_kotlin_retrofit.data.local.LocalDataHelperImpl
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import com.example.dagger_kotlin_retrofit.data.network.ApiHelperImpl
import com.example.dagger_kotlin_retrofit.data.network.IApiHelper
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: IApiHelper,
    private val local:ILocalDataHelper
) : IRepository {

    override fun getData(user: String?): Observable<User> {
        return api.getData(user);
    }

    override fun getUsers(): Observable<List<User>> {
        return api.getUsers()
    }

    override fun getUser(): Single<List<UserLocal>> {
        return local.getUser();
    }

    override fun insertUser(userLocal: UserLocal): Completable {
        return local.insertUser(userLocal);
    }
}