package com.example.dagger_kotlin_retrofit.di.module

import android.content.Context
import androidx.room.Room
import com.example.dagger_kotlin_retrofit.MyApplication
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.data.local.ILocalDataHelper
import com.example.dagger_kotlin_retrofit.data.local.LocalDataBase
import com.example.dagger_kotlin_retrofit.data.local.LocalDataHelperImpl
import com.example.dagger_kotlin_retrofit.data.network.ApiHelperImpl
import com.example.dagger_kotlin_retrofit.data.network.IApiHelper
import dagger.Module
import dagger.Provides
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
    fun providerApiHelper(): IApiHelper {
        return ApiHelperImpl();
    }
    @Provides
    @Singleton
    fun providerLocalHelper(context:Context):ILocalDataHelper{
        return LocalDataHelperImpl(context);
    }
    @Provides
    @Singleton
    fun providerLocalDatabase(context: Context, databaseName: String): LocalDataBase {
        return Room.databaseBuilder(
            context, LocalDataBase::class.java, databaseName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDatabaseName(): String? {
        return LocalDataBase.DATA_BASE_NAME
    }
}