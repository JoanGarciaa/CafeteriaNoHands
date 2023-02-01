package com.example.cafeteria_nohands.src.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteria_nohands.src.model.Usuari
import com.example.cafeteria_nohands.src.repository.PlatoRepositori
import com.example.cafeteria_nohands.src.repository.UserRepositori


public class UsuariViewModel : ViewModel() {

    var usuari : LiveData<List<Usuari>>?=null;

    fun loginClient(context: Context, nombre: String, passw: String): LiveData<List<Usuari>>?{
        usuari = UserRepositori.userLogin(context,nombre,passw)
        return usuari
    }

    fun newUser(context: Context, nombre : String, email : String, user : String, passw: String){
        var clientVM= Usuari(nombre,email,user,passw)
        UserRepositori.insertUsuari(context,clientVM)
    }

}