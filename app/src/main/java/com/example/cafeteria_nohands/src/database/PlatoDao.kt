package com.example.cafeteria_nohands.src.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cafeteria_nohands.src.model.Plato
import com.example.cafeteria_nohands.src.model.Usuari

@Dao
interface PlatoDao {

    @Query("SELECT * FROM platos WHERE categoria = 1")
    fun getPlatos1(): LiveData<List<Plato>>

    @Query("SELECT * FROM platos WHERE categoria = 2")
    fun getPlatos2(): LiveData<List<Plato>>

    @Query("SELECT * FROM platos WHERE categoria = 3")
    fun getPlatos3(): LiveData<List<Plato>>


}