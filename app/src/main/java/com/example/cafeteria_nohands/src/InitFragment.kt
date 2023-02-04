package com.example.cafeteria_nohands.src

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData.Item
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeteria_nohands.MainActivity
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.databinding.FragmentInitBinding


class InitFragment : Fragment() {

    //@SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInitBinding>(
            inflater,
            R.layout.fragment_init, container, false
        )

        setHasOptionsMenu(true)
        binding.buttonPedir.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_initFragment_to_plato1Fragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.closeApp) {
            System.exit(0)
        }
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}