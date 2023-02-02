package com.example.cafeteria_nohands.src.viewmodel;

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import com.example.cafeteria_nohands.src.model.Plato
import com.example.cafeteria_nohands.src.repository.PlatoRepositori

public class OrderViewModel : ViewModel() {

    val listData = ArrayList<Plato>()
    var plato : LiveData<List<Plato>>?=null;
    var historial = ArrayList<Plato>()

    fun setPlato(plato: Plato){
        listData.add(plato)
    }

    fun getPlatos():ArrayList<Plato>{
        return listData
    }

    fun getPlatos1(context: Context): LiveData<List<Plato>>?{
        plato = PlatoRepositori.getPlatos1(context)
        return plato
    }

    fun getPlatos2(context: Context): LiveData<List<Plato>>?{
        plato = PlatoRepositori.getPlatos2(context)
        return plato
    }

    fun getPlatos3(context: Context): LiveData<List<Plato>>?{
        plato = PlatoRepositori.getPlatos3(context)
        return plato
    }

    fun setHistorial(plato: Plato){
        historial.add(plato)
    }

    fun getHistorial(context: Context): ArrayList<Plato>{
        return historial
    }

    fun deleteHistorial(plato:Plato){
        listData.removeAll(listOf(plato).toSet())
    }





}


