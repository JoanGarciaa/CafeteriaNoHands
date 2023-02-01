package com.example.cafeteria_nohands.src.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuaris")
data class Usuari(
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "user")
    val user: String,
    @ColumnInfo(name = "password")
    val password: String,
)
{
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}