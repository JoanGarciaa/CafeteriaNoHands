package com.example.cafeteria_nohands.src.model

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PlatoDao {

    @Query("SELECT * FROM platos WHERE categoria = 1")
    fun getPlatos1(): LiveData<List<Plato>>

    @Query("SELECT * FROM platos WHERE categoria = 2")
    fun getPlatos2(): LiveData<List<Plato>>

    @Query("SELECT * FROM platos WHERE categoria = 3")
    fun getPlatos3(): LiveData<List<Plato>>

    @Query("SELECT * FROM usuaris WHERE user=:usuari & password=:contraseña")
    fun loginUser(usuari:String, contraseña:String): LiveData<List<Usuari>>

}