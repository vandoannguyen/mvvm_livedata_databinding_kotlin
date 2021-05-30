package com.example.dagger_kotlin_retrofit.data.local

import com.example.dagger_kotlin_retrofit.data.local.dao.CountryDAO
import com.example.dagger_kotlin_retrofit.data.local.dao.UserDAO
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalDataHelperImpl : ILocalDataHelper {
    var userDao: UserDAO;
    var countryDAO: CountryDAO;

    @Inject
    constructor(userDao: UserDAO, countryDAO: CountryDAO) {
        this.userDao = userDao
        this.countryDAO = countryDAO
    }

//    constructor(context: Context) {
//        userDao = LocalDataBase.getDataBase(context).getUserDAO()
//        countryDAO = LocalDataBase.getDataBase(context).getCountryDAO()
//    }

    override fun getUser(): Single<List<UserLocal>> {
        return Single.create {
            it.onSuccess(userDao.getUser() ?: ArrayList());
        };
    }

    override fun insertUser(userLocal: UserLocal): Completable {
        return Completable.create {
            userDao.insert(userLocal);
            it.onComplete();
        };
    }
}