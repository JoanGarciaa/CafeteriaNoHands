package com.example.cafeteria_nohands.src.fragment.pedido

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentPlato1Binding
import com.example.cafeteria_nohands.src.adapter.ListAdapter
import com.example.cafeteria_nohands.src.data.Provider
import com.example.cafeteria_nohands.src.model.OrderViewModel
import com.example.cafeteria_nohands.src.model.Plato

class Plato1Fragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPlato1Binding>(
            inflater,
            R.layout.fragment_plato1, container, false
        )


        val recyclerView = binding.recyclerView
        val adapter = ListAdapter(Provider().primerosPlato())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


//        binding?.apply {
//            lifecycleOwner = viewLifecycleOwner
//            viewModel = sharedViewModel
//            plato1fragment = this@Plato1Fragment
//        }
//
//        sharedViewModel.name.observe(viewLifecycleOwner,{ name  ->
//            binding.viewModel?.name
//        })





        //val spinnerInfo = resources.getStringArray(R.array.spinner_plat1)
        //var arrayAdapter = ArrayAdapter(requireContext(),R.layout.item_dropdown,spinnerInfo)

//        fun orderPlato1(name: String, price: Int) {
//            // Update the view model with the quantity
//            sharedViewModel.setOrderNames(name)
//            sharedViewModel.setOrderPrice(price)
//
//        }

        adapter.setOnItemClickListener(object : ListAdapter.onItemClickListener{
            override fun onItemClick(plato: Plato) {
                sharedViewModel.setPlato(plato)
                Toast.makeText(requireContext(), "${plato.nombre}", Toast.LENGTH_SHORT).show()
            }
        })

        binding.buttontoPlat1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_plato1Fragment_to_plato2Fragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }


}