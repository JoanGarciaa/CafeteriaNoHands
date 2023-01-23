package com.example.cafeteria_nohands.src.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class Plato(val nombre : String, val detalles : String, val precio : Int, val image : Int)



@Entity(tableName = "platos")
    data class Plato(
        @PrimaryKey
        @ColumnInfo(name = "nombrePlato")
        val nombre: String,
        @ColumnInfo(name = "detallesPlato")
        var detalles: String,
        @ColumnInfo(name = "precioPlato")
        val precio: Int,
        @ColumnInfo(name = "imgPlato")
        val image: Int,
)

