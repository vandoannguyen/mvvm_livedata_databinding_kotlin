package com.example.dagger_kotlin_retrofit.data.local.dao

import androidx.room.*
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import io.reactivex.rxjava3.core.Single


@Dao
interface UserDAO {
    companion object {
        const val USER_TABLE_NAME: String = "User";
    }

    @Query("SELECT*FROM $USER_TABLE_NAME")
    suspend fun getUser(): Single<List<UserLocal>>;

    @Query("SELECT*FROM $USER_TABLE_NAME where ${"id"} = (:id)")
    suspend fun getUser(id: Int): Single<UserLocal>;

    @Insert
    suspend fun insert(user: UserLocal): Single<Void>;

    @Insert
    suspend fun insert(users: List<UserLocal>): Single<Void>;

    @Update
    suspend fun update(user: UserLocal): Single<Boolean>;

    @Delete
    suspend fun delete(user: UserLocal): Single<Void>;
}