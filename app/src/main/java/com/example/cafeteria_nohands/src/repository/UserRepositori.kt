package com.example.cafeteria_nohands.src.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.cafeteria_nohands.src.database.PlatoDatabase
import com.example.cafeteria_nohands.src.model.Usuari
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositori {

    companion object{
        var platosDatabase: PlatoDatabase? = null
        var usuari:LiveData<List<Usuari>>? = null

        fun initializeDB(context: Context): PlatoDatabase {
            return PlatoDatabase.getDatabase(context)
        }

        fun userLogin(context: Context, nombre:String, password:String): LiveData<List<Usuari>>? {
            platosDatabase = initializeDB(context)
            usuari = platosDatabase!!.userDao().loginUser(nombre,password)
            return usuari
        }

        fun insertUsuari(context: Context, usuari: Usuari){
            platosDatabase = initializeDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                platosDatabase!!.userDao().addUser(usuari)
            }
        }

    }
}