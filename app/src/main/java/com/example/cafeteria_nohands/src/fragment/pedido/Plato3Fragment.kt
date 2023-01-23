package com.example.cafeteria_nohands.src.fragment.pedido

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentPlato3Binding
import com.example.cafeteria_nohands.src.adapter.ListAdapter
import com.example.cafeteria_nohands.src.data.Provider
import com.example.cafeteria_nohands.src.model.OrderViewModel
import com.example.cafeteria_nohands.src.model.Plato

class Plato3Fragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    lateinit var recyclerView: RecyclerView
    private lateinit var listPlatosAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPlato3Binding>(
            inflater,
            R.layout.fragment_plato3, container, false
        )

        setHasOptionsMenu(true)

        val recyclerView = binding.recyclerView
        val adapter = ListAdapter(Provider().postres())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter



        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            plato3fragment = this@Plato3Fragment
        }

        binding.buttontoPlat3.setOnClickListener {view: View->
            view.findNavController().navigate(R.id.action_plato3Fragment_to_pagarFragment)
        }

        binding.recyclerView.setOnClickListener(){
            var plato = Plato(
                binding.recyclerView.toString(),
                binding.recyclerView.toString(),
                binding.recyclerView.toString().toInt(),
                binding.recyclerView.toString().toInt(),
            )
            print("hol $plato")
        }

        adapter.setOnItemClickListener(object : ListAdapter.onItemClickListener{
            override fun onItemClick(plato: Plato) {
                sharedViewModel.setPlato(plato)
                Toast.makeText(requireContext(), "${plato.nombre}", Toast.LENGTH_SHORT).show()
            }
        })

//        val platosObserver = Observer<ArrayList<Plato>>{
//            listPlatosAdapter = ListAdapter(it)
//            recyclerView.layoutManager = LinearLayoutManager(requireContext())
//            recyclerView.setHasFixedSize(true)
//            recyclerView.adapter = listPlatosAdapter
//
//
//
//        }
        //sharedViewModel.getListaAlumnesLiveData().observe(viewLifecycleOwner,platosObserver)
        return binding.root
    }


}