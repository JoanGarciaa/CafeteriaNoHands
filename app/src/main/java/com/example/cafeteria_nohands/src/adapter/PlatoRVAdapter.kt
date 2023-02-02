package com.example.cafeteria_nohands.src.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.src.model.Plato

class   PlatoRVAdapter : ListAdapter<Plato, PlatoRVAdapter.PlatoHolder>(DiffCallback()) {

    class PlatoHolder(view:View): RecyclerView.ViewHolder(view)
    private lateinit var listener: RecyclerClickListener

    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        val platoHolder = PlatoHolder(v)


        val plato = platoHolder.itemView.findViewById<CardView>(R.id.card_view)
        plato.setOnClickListener {
            listener.onItemClick(platoHolder.adapterPosition)
        }
        return platoHolder
    }

    override fun onBindViewHolder(holder: PlatoHolder, position: Int) {
        val currentItem = getItem(position)
        val nombre = holder.itemView.findViewById<TextView>(R.id.item_title)
        nombre.text = currentItem.nombre
        val precio = holder.itemView.findViewById<TextView>(R.id.item_price)
        precio.text = currentItem.precio.toString()
        val detalles = holder.itemView.findViewById<TextView>(R.id.item_detal)
        detalles.text = currentItem.detalles
        var img = currentItem.nombre + ".png"
        Log.e(img,"img")
        // Close to working
        Glide.with(holder.itemView).load("C:\\Users\\Joan Garcia\\AndroidStudioProjects\\CafeteriaNoHands-main\\CafeteriaNoHands\\app\\src\\main\\res\\drawable\\" + img).into(holder.itemView.findViewById(R.id.item_image));

    }

    class DiffCallback : DiffUtil.ItemCallback<Plato>() {
        override fun areItemsTheSame(oldItem: Plato, newItem: Plato) =
            oldItem.nombre == newItem.nombre

        override fun areContentsTheSame(oldItem: Plato, newItem: Plato) =
            oldItem == newItem
    }

}