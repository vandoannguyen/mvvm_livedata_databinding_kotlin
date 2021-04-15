package com.example.dagger_kotlin_retrofit.data.local.dao

import androidx.room.*
import com.example.dagger_kotlin_retrofit.data.mode.local.CountryLocal
import io.reactivex.rxjava3.core.Single
@Dao
interface CountryDAO {
    companion object {
        const val COUNTRY_TABLE_NAME = "country"
    }

    @Insert
    fun insert(countyLocal: CountryLocal): Single<Void>;

    @Insert
    fun insert(countyLocals: List<CountryLocal>): Single<Void>;

    @Update
    fun update(countyLocal: CountryLocal): Single<Void>;

    @Delete
    fun delete(countyLocal: CountryLocal): Single<Void>;

    @Query("SELECT * FROM ${COUNTRY_TABLE_NAME}")
    fun getCountries(): Single<List<CountryLocal>>

    @Query("SELECT * FROM ${COUNTRY_TABLE_NAME} Where ${"id"} = (:id)")
    fun getCountries(id: Int): Single<CountryLocal>

}