package com.example.cafeteria_nohands.src.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.src.model.Plato

class ListAdapter(private val dataset: ArrayList<Plato>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(plato: Plato)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val data = dataset.get(i)
        viewHolder.itemTitle.text = data.nombre
        viewHolder.itemDetail.text = data.detalles
        viewHolder.itemPrice.text = data.precio.toString()
        viewHolder.itemImage.setImageResource(data.image)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemPrice: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
            itemPrice = itemView.findViewById(R.id.item_price)

            itemView.setOnClickListener {
                listener.onItemClick(Plato(
                    itemTitle.text.toString(),
                    itemDetail.text.toString(),
                    itemPrice.text.toString().toInt(),
                    R.drawable.ic_launcher_foreground
                ))
            }
        }
    }
}