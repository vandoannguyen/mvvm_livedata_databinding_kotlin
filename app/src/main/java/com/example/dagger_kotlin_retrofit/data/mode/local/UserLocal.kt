package com.example.dagger_kotlin_retrofit.data.mode.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.dagger_kotlin_retrofit.data.local.dao.UserDAO.Companion.USER_TABLE_NAME

@Entity(tableName = "$USER_TABLE_NAME")
data class UserLocal(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String?,
){

}