package com.example.cafeteria_nohands.src.fragment.compra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentPagarBinding
import com.example.cafeteria_nohands.databinding.FragmentPlato1Binding
import com.example.cafeteria_nohands.src.adapter.ListAdapter
import com.example.cafeteria_nohands.src.data.Provider
import com.example.cafeteria_nohands.src.model.OrderViewModel
import com.example.cafeteria_nohands.src.model.Plato


class PagarFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    private lateinit var recyclerview : RecyclerView
    private lateinit var adapter : ListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPagarBinding>(
            inflater, R.layout.fragment_pagar, container, false
        )

        var textPrecio = binding.textView2
        recyclerview = binding.recyclerView
        adapter = ListAdapter(sharedViewModel.getPlatos())
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : ListAdapter.onItemClickListener{
            override fun onItemClick(plato: Plato) {
                Toast.makeText(requireContext(), "${plato.precio}", Toast.LENGTH_SHORT).show()
                textPrecio.text = plato.precio.toString()
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }
}