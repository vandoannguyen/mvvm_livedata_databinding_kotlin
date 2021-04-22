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
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {
    private var myapplication: MyApplication

    constructor(myApplication: MyApplication) {
        this.myapplication = myApplication;
    }

    @Binds
    abstract fun providerContext(): Context;

    @Binds
    abstract fun providerRepository(
        iRepository: IRepository
    ): RepositoryImpl;

    @Binds
    abstract fun providerApiHelper(iApiHelper: IApiHelper): ApiHelperImpl;

    @Binds
    abstract fun providerLocalHelper(iLocalDataHelper: ILocalDataHelper): LocalDataHelperImpl;

    @Provides
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