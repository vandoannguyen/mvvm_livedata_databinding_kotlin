package com.example.dagger_kotlin_retrofit.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single


@Dao
interface UserDAO {
    companion object {
        const val USER_TABLE_NAME: String = "User";
    }

    @Query("SELECT*FROM $USER_TABLE_NAME")
    fun getUser(): List<UserLocal>;

    @Query("SELECT*FROM $USER_TABLE_NAME where ${"id"} = (:id)")
    fun getUser(id: Int): UserLocal;

    @Insert
    fun insert(vararg user: UserLocal): Void;

    @Update
    fun update(user: UserLocal): Int;

    @Delete
    fun delete(user: UserLocal): Int;
}