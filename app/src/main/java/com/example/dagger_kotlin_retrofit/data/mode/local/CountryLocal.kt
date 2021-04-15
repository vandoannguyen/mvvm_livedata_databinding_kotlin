package com.example.dagger_kotlin_retrofit.data.mode.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dagger_kotlin_retrofit.data.local.dao.CountryDAO.Companion.COUNTRY_TABLE_NAME

@Entity(tableName = "$COUNTRY_TABLE_NAME")
data class CountryLocal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name")
    val name: String?
) {

}