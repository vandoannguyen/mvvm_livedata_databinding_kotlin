package com.example.dagger_kotlin_retrofit.data

import com.example.dagger_kotlin_retrofit.data.local.ILocalDataHelper
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import com.example.dagger_kotlin_retrofit.data.network.IApiHelper
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl : IRepository {

    var api: IApiHelper;
    var local: ILocalDataHelper;

    @Inject
    constructor(apiHelperImpl: IApiHelper, iLocalDataHelper: ILocalDataHelper) {
        this.api = apiHelperImpl;
        this.local = iLocalDataHelper;
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