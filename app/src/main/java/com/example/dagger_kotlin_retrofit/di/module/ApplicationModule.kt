package com.example.dagger_kotlin_retrofit.di.module

import android.content.Context
import androidx.room.Room
import com.example.dagger_kotlin_retrofit.MyApplication
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.RepositoryImpl
import com.example.dagger_kotlin_retrofit.data.local.LocalDataBase
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
    fun providerRepository(context: Context): IRepository {
        return RepositoryImpl(context);
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