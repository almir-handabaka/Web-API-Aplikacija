package com.example.webapi.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.webapi.KlikZaDetalje
import com.example.webapi.ListaFragmentDirections
import com.example.webapi.Podaci
import com.example.webapi.R
import kotlinx.android.synthetic.main.kartica.view.*


class ItemAdapter(private val podaci: ArrayList<Podaci>, private val KlikZaDetalje: KlikZaDetalje) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.kartica, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val podatak = podaci[position]

        holder.itemView.nazivValute.text = podatak.nazivValute
        holder.itemView.simbolValute.text = podatak.simbol
        holder.itemView.rankValute.text = "rank: #" + podatak.rank.toString()
        holder.itemView.cijenaValute.text = "cijena: $" + podatak.cijena.toString()

        holder.itemView.karticaKripto.setOnClickListener{
           KlikZaDetalje.onKriptoItemClicked(position)
        }

    }

    override fun getItemCount() = podaci.size


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}