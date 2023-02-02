package com.example.cafeteria_nohands.src.fragment.pedido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentPlato1Binding
import com.example.cafeteria_nohands.src.adapter.PlatoRVAdapter
import com.example.cafeteria_nohands.src.adapter.RecyclerClickListener
import com.example.cafeteria_nohands.src.viewmodel.OrderViewModel

class Plato1Fragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    private lateinit var binding: FragmentPlato1Binding
    private lateinit var adapter: PlatoRVAdapter
    lateinit var platoViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate<FragmentPlato1Binding>(inflater, R.layout.fragment_plato1,container,false);
        platoViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)


        binding.buttontoPlat1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_plato1Fragment_to_plato2Fragment)
        }

        setRecyclerView()
        observePlato()
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun setRecyclerView() {

        val platoRecyclerview = binding.recyclerView
        platoRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        platoRecyclerview.setHasFixedSize(true)
        adapter = PlatoRVAdapter()
        adapter.setItemListener(object : RecyclerClickListener {

            override fun onItemClick(position: Int) {
                val platoList = adapter.currentList.toMutableList()
                sharedViewModel.setPlato(platoList[position])
                Toast.makeText(requireContext(),"Primer Plato Añadido" , Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(R.id.action_plato1Fragment_to_plato2Fragment)
            }

        })
        platoRecyclerview.adapter = adapter
    }

    private fun observePlato() {
        platoViewModel.getPlatos1(requireContext())!!.observe(viewLifecycleOwner, Observer { llistaPlato ->
            adapter.submitList(llistaPlato)
        })
    }


}