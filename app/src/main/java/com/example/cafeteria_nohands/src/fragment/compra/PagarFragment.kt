package com.example.cafeteria_nohands.src.fragment.compra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentPagarBinding
import com.example.cafeteria_nohands.src.adapter.PlatoRVAdapter
import com.example.cafeteria_nohands.src.adapter.RecyclerClickListener
import com.example.cafeteria_nohands.src.viewmodel.OrderViewModel


class PagarFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    private lateinit var adapter: PlatoRVAdapter
    private lateinit var binding: FragmentPagarBinding
    lateinit var platoViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentPagarBinding>(
            inflater,
            R.layout.fragment_pagar,
            container,
            false
        );
        platoViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        setRecyclerView()
        observePlato()

        binding.buttonPagar.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_pagarFragment_to_historialFragment)
            Toast.makeText(requireContext(),"Gracias por tu compra! BUEN PROVECHO!" , Toast.LENGTH_SHORT).show()
        }
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
                Toast.makeText(requireContext(),"Hol" , Toast.LENGTH_SHORT).show()
            }
        })
        platoRecyclerview.adapter = adapter
    }

    private fun observePlato() {
        adapter.submitList(
            sharedViewModel.getPlatos()
        )
        setTotalPrice()
    }

    fun setTotalPrice(){
        var platoList = adapter.currentList.toMutableList()
        var precio = 0
        for (plato in platoList){
            precio += plato.precio
        }
        binding.textViewPrecioTotal.text = "Total: " + precio.toString() + " €"
    }
}