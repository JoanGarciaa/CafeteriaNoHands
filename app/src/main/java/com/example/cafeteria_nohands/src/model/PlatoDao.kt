package com.example.cafeteria_nohands.src.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PlatoDao {

    @Query("SELECT * FROM platos")
    fun getPlatos(): Flow<List<Plato>>

}