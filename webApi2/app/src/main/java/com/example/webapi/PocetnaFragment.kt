package com.example.webapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.webapi.databinding.FragmentPocetnaBinding

class PocetnaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPocetnaBinding>(inflater, R.layout.fragment_pocetna, container, false)
        binding.postavkeButton.setOnClickListener { view : View ->
            Log.i("problem", "usao u dugme za postavke")
            view.findNavController().navigate(R.id.action_pocetnaFragment_to_postavkeFragment)
        }

        binding.daljeButton.setOnClickListener { view : View ->
            Log.i("problem", "usao u dugme za dalje")
            view.findNavController().navigate(R.id.action_pocetnaFragment_to_listaFragment)

        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_opcije, menu)
    }

    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "Ovdje ide predefinisana poruka!")
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Share -> shareSuccess()
            else -> {
                NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                        || super.onOptionsItemSelected(item)
            }
        }
        return true

    }

}