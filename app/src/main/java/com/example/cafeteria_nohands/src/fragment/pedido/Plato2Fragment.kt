package com.example.cafeteria_nohands.src.fragment.pedido

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentPlato2Binding
import com.example.cafeteria_nohands.src.adapter.ListAdapter
import com.example.cafeteria_nohands.src.data.Provider
import com.example.cafeteria_nohands.src.model.OrderViewModel
import com.example.cafeteria_nohands.src.model.Plato

class Plato2Fragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPlato2Binding>(
            inflater,
            R.layout.fragment_plato2, container, false
        )

        setHasOptionsMenu(true)


        val recyclerView = binding.recyclerView
        val adapter = ListAdapter(Provider().segundosPlato())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : ListAdapter.onItemClickListener{
            override fun onItemClick(plato: Plato) {
                sharedViewModel.setPlato(plato)
                Toast.makeText(requireContext(), "${plato.nombre}", Toast.LENGTH_SHORT).show()
            }
        })


        binding.buttontoPlat2.setOnClickListener {view: View->
            view.findNavController().navigate(R.id.action_plato2Fragment_to_plato3Fragment)
        }

        return binding.root
    }


}