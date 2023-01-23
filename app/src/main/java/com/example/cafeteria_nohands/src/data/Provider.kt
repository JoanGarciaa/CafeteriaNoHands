package com.example.cafeteria_nohands.src.data

import com.example.cafeteria_nohands.src.model.Plato
import com.example.cafeteria_nohands.R

class Provider {
    companion object{
        private val primerPlato = arrayListOf<Plato>(
            Plato("Macarrones al pesto","molts maccarro",12,R.drawable.ic_launcher_foreground),
            Plato("Pizza Hawaiana","molts maccarro",9,R.drawable.ic_launcher_foreground),
            Plato("Canelones de Foie","molts maccarro",11,R.drawable.ic_launcher_foreground),
            Plato("Bistec con patatas","molts maccarro",10,R.drawable.ic_launcher_foreground)
        )
        private val segundoPlato = arrayListOf<Plato>(
            Plato("Pulpo a la gallega","molts maccarro",14,R.drawable.ic_launcher_foreground),
            Plato("Salmon ahumado","molts maccarro",13,R.drawable.ic_launcher_foreground),
            Plato("Carne rebozada con patatas","molts maccarro",9,R.drawable.ic_launcher_foreground),
            Plato("Melon con jamón","molts maccarro",8,R.drawable.ic_launcher_foreground)
        )
        private val postres = arrayListOf<Plato>(
            Plato("Tarta de queso","molts maccarro",4,R.drawable.ic_launcher_foreground),
            Plato("Sorbete de limón","molts maccarro",3,R.drawable.ic_launcher_foreground),
            Plato("Arroz con leche","molts maccarro",3,R.drawable.ic_launcher_foreground),
            Plato("Coulant de chocolate","molts maccarro",4,R.drawable.ic_launcher_foreground)
        )
    }
    fun primerosPlato(): ArrayList<Plato>{
        return primerPlato
    }
    fun segundosPlato(): ArrayList<Plato>{
        return segundoPlato
    }
    fun postres(): ArrayList<Plato>{
        return postres
    }


}