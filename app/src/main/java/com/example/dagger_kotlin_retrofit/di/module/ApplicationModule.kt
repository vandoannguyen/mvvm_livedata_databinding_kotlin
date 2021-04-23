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
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun providerRepository(
        iLocalDataHelper: ILocalDataHelper,
        iApiHelper: IApiHelper
    ): IRepository = RepositoryImpl(iApiHelper, iLocalDataHelper)

    @Provides
    @Singleton
    fun providerApiHelper(): IApiHelper = ApiHelperImpl();

    @Provides
    @Singleton
    fun providerLocalHelper(@ApplicationContext context: Context): ILocalDataHelper =
        LocalDataHelperImpl(context)

    @Provides
    @Singleton
    fun providerLocalDatabase(
        @ApplicationContext context: Context
    ): LocalDataBase =
        Room.databaseBuilder(
            context, LocalDataBase::class.java, LocalDataBase.DATA_BASE_NAME
        ).fallbackToDestructiveMigration().build() as LocalDataBase

}