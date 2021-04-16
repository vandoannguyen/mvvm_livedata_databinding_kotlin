package com.example.dagger_kotlin_retrofit.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dagger_kotlin_retrofit.data.local.dao.CountryDAO
import com.example.dagger_kotlin_retrofit.data.local.dao.UserDAO
import com.example.dagger_kotlin_retrofit.data.mode.local.CountryLocal
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import javax.inject.Inject


@Database(
    entities = [CountryLocal::class, UserLocal::class],
    version = 1,
    exportSchema = true
)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun getUserDAO(): UserDAO;
    abstract fun getCountryDAO(): CountryDAO;

    companion object {
        val DATA_BASE_NAME: String = "LocalDataBase"
        private var database: LocalDataBase? = null;
        fun getDataBase(context: Context): LocalDataBase {
            return database ?: Room.databaseBuilder(
                context,
                LocalDataBase::class.java,
                DATA_BASE_NAME
            ).fallbackToDestructiveMigration().build();
        }
    }
}