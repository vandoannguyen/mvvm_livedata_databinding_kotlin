package com.example.dagger_kotlin_retrofit.data.local

import android.content.Context
import androidx.room.Dao
import com.example.dagger_kotlin_retrofit.data.local.dao.CountryDAO
import com.example.dagger_kotlin_retrofit.data.local.dao.UserDAO
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import io.reactivex.rxjava3.core.Single

class LocalDataHelperImpl : ILocalDataHelper {
    var userDao: UserDAO;
//    var countryDAO: CountryDAO;

    constructor(context: Context) {
        userDao = LocalDataBase.getDataBase(context).getUserDAO()
//        countryDAO = LocalDataBase.getDataBase(context).getCountryDAO()
    }

    override fun getUser(): Single<List<UserLocal>> {
        return this.userDao.getUser();
    }

    override fun insertUser(userLocal: UserLocal): Single<Void> {
        return userDao.insert(userLocal);
    }
}