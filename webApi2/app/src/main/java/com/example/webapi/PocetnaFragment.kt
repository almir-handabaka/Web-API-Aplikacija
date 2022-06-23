package com.example.webapi

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.webapi.database.KriptoViewModel
import com.example.webapi.databinding.FragmentPocetnaBinding
import com.example.webapi.network.MainViewModel


class PocetnaFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    lateinit private var mContext: Context
    private lateinit var  myKriptoViewModel: KriptoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
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


        if (AppStatus1.getInstance(mContext).isOnline) {
            Log.i("wifi status", "online je")

        } else {
            Log.i("wifi status", "nije online")
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
            .putExtra(Intent.EXTRA_TEXT, "Provjeri vrijednost top kriptovaluta koristeći najnoviju aplikaciju KriptoInfo :)")
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