package com.example.dagger_kotlin_retrofit.di.module

import android.content.Context
import androidx.room.Room
import com.example.dagger_kotlin_retrofit.MyApplication
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.data.local.ILocalDataHelper
import com.example.dagger_kotlin_retrofit.data.local.LocalDataBase
import com.example.dagger_kotlin_retrofit.data.local.LocalDataHelperImpl
import com.example.dagger_kotlin_retrofit.data.local.dao.CountryDAO
import com.example.dagger_kotlin_retrofit.data.local.dao.UserDAO
import com.example.dagger_kotlin_retrofit.data.network.IApiHelper
import com.example.dagger_kotlin_retrofit.data.network.provider.RetrofitClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApplicationModule {
    private var myapplication: MyApplication

    constructor(myApplication: MyApplication) {
        this.myapplication = myApplication;
    }

    @Provides
    @Singleton
    fun providerContext(): Context {
        return myapplication;
    }

    @Provides
    @Singleton
    fun providerRepository(
        iApiHelper: IApiHelper,
        iLocalDataHelper: ILocalDataHelper
    ): IRepository {
        return RepositoryImpl(iApiHelper, iLocalDataHelper);
    }

    @Provides
    @Singleton
    fun providerClient(): Retrofit {
        return RetrofitClient.getClient("https://api.github.com")!!
    }

    @Provides
    @Singleton
    fun providerApiHelper(retrofit: Retrofit): IApiHelper {
        return retrofit.create(IApiHelper::class.java)
    }

    @Provides
    @Singleton
    fun providerLocalHelper(userDAO: UserDAO, countryDAO: CountryDAO): ILocalDataHelper {
        return LocalDataHelperImpl(userDAO, countryDAO);
    }

    @Provides
    @Singleton
    fun providerUserDao(localDataBase: LocalDataBase): UserDAO {
        return localDataBase.getUserDAO();
    }

    @Provides
    @Singleton
    fun providerCountryDao(localDataBase: LocalDataBase): CountryDAO {
        return localDataBase.getCountryDAO();
    }

    @Provides
    @Singleton
    fun providerLocalDatabase(context: Context): LocalDataBase {
        return Room.databaseBuilder(
            context, LocalDataBase::class.java, LocalDataBase.DATA_BASE_NAME
        ).fallbackToDestructiveMigration().build();
//        return LocalDataBase.getDataBase(context);
    }

    @Provides
    @Singleton
    fun provideDatabaseName(): String? {
        return LocalDataBase.DATA_BASE_NAME
    }
}