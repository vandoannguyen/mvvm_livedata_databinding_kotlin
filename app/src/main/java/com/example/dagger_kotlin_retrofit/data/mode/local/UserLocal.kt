package com.example.dagger_kotlin_retrofit.data.mode.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dagger_kotlin_retrofit.data.local.dao.UserDAO.Companion.USER_TABLE_NAME

@Entity(tableName = "$USER_TABLE_NAME")
data class UserLocal(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
){

}