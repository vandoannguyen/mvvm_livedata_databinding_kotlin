package com.example.dagger_kotlin_retrofit.data.local

import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import io.reactivex.rxjava3.core.*

interface ILocalDataHelper {
    fun getUser(): Single<List<UserLocal>>;
    fun insertUser(userLocal: UserLocal): Completable;
}