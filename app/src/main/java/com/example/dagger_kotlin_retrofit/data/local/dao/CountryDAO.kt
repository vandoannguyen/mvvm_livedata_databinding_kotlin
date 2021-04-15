package com.example.dagger_kotlin_retrofit.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dagger_kotlin_retrofit.data.mode.local.CountryLocal
import io.reactivex.rxjava3.core.Single

@Dao
interface CountryDAO {
    companion object {
        const val COUNTRY_TABLE_NAME = "country"
    }

    @Insert
    fun insert(vararg countyLocal: CountryLocal): Void;

    @Update
    fun update(countyLocal: CountryLocal): Int;

    @Delete
    fun delete(countyLocal: CountryLocal): Int;

    @Query("SELECT * FROM ${COUNTRY_TABLE_NAME}")
    fun getCountries(): LiveData<List<CountryLocal>>

    @Query("SELECT * FROM ${COUNTRY_TABLE_NAME} Where ${"id"} = (:id)")
    fun getCountries(id: Int): LiveData<CountryLocal>

}