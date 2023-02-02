package com.example.cafeteria_nohands.src.about

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.cafeteria_nohands.MainActivity
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentContactoBinding
import com.example.cafeteria_nohands.databinding.FragmentPlato1Binding
import com.example.cafeteria_nohands.databinding.FragmentPlato2Binding
import com.example.cafeteria_nohands.src.LoginActivity


class ContactoFragment : Fragment() {
    private lateinit var binding: FragmentContactoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate<FragmentContactoBinding>(inflater, R.layout.fragment_contacto,container,false);

        binding.buttonEnviarFormulario.setOnClickListener{
            Toast.makeText(requireContext(),"Gracias por enviar tu formulario, en breves atenderemos tu respuesta" , Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

}