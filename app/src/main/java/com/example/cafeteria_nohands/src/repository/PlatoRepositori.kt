package com.example.cafeteria_nohands.src.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.cafeteria_nohands.src.model.Plato
import com.example.cafeteria_nohands.src.model.PlatoDatabase
import com.example.cafeteria_nohands.src.model.Usuari

class PlatoRepositori {
    companion object{
        var platosDatabase: PlatoDatabase? = null

        var usuari:LiveData<List<Usuari>>? = null
        fun initializeDB(context: Context): PlatoDatabase {
            return PlatoDatabase.getDatabase(context)
        }

        fun getPlatos1(context: Context): LiveData<List<Plato>> {
            platosDatabase = initializeDB(context)
            return platosDatabase!!.platoDao().getPlatos1()
        }

        fun getPlatos2(context: Context): LiveData<List<Plato>> {
            platosDatabase = initializeDB(context)
            return platosDatabase!!.platoDao().getPlatos2()
        }

        fun getPlatos3(context: Context): LiveData<List<Plato>> {
            platosDatabase = initializeDB(context)
            return platosDatabase!!.platoDao().getPlatos3()
        }

        fun userLogin(context: Context, nombre:String, contraseña:String):LiveData<List<Usuari>>? {
            platosDatabase = initializeDB(context)
            usuari = platosDatabase!!.platoDao().loginUser(nombre,contraseña)
            return usuari
        }

    }
}