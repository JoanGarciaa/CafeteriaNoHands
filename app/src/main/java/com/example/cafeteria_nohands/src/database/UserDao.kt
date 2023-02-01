package com.example.cafeteria_nohands.src.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cafeteria_nohands.src.model.Usuari

@Dao
interface UserDao {

    @Query("SELECT * FROM usuaris WHERE user=:usuari AND password=:contraseña")
    fun loginUser(usuari:String, contraseña:String): LiveData<List<Usuari>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(usuari: Usuari)
}