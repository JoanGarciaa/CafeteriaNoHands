package com.example.cafeteria_nohands.src.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "platos")
    data class Plato(
        @PrimaryKey
        @ColumnInfo(name = "nombrePlato")
        val nombre: String,
        @ColumnInfo(name = "detallesPlato")
        var detalles: String,
        @ColumnInfo(name = "precioPlato")
        val precio: Int,
        @ColumnInfo(name = "categoria")
        val categoria: Int,
)

