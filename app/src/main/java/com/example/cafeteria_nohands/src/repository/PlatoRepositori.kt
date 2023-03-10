package com.example.cafeteria_nohands.src.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.cafeteria_nohands.src.model.Plato
import com.example.cafeteria_nohands.src.database.PlatoDatabase
import com.example.cafeteria_nohands.src.model.Usuari
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlatoRepositori {
    companion object{
        var platosDatabase: PlatoDatabase? = null

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

    }
}