package com.example.cafeteria_nohands.src.model;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel : ViewModel() {

    val listData = ArrayList<Plato>()

    fun setPlato(plato: Plato){
        listData.add(plato)
    }

    fun getPlatos(): ArrayList<Plato>{
        return listData
    }

}


