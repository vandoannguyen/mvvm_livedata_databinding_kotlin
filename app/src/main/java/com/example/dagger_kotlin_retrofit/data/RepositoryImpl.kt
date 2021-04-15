package com.example.dagger_kotlin_retrofit.data

import android.content.Context
import com.example.dagger_kotlin_retrofit.data.local.ILocalDataHelper
import com.example.dagger_kotlin_retrofit.data.local.LocalDataHelperImpl
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import com.example.dagger_kotlin_retrofit.data.network.ApiHelperImpl
import com.example.dagger_kotlin_retrofit.data.network.IApiHelper
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class RepositoryImpl : IRepository {
    companion object {
        private var INSTANCE: RepositoryImpl? = null;
        fun getInstance(context: Context): RepositoryImpl {
            return INSTANCE ?: RepositoryImpl(context);
        }
    }

    var api: IApiHelper;
    var local: ILocalDataHelper;

    constructor(context: Context) {
        api = ApiHelperImpl();
        local = LocalDataHelperImpl(context);
    }

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