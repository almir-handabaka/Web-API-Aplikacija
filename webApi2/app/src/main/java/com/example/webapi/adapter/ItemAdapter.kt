package com.example.webapi.adapter


import android.content.Context
import android.graphics.Picture
import android.graphics.drawable.PictureDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webapi.KlikZaDetalje
import com.example.webapi.Postavke
import com.example.webapi.R
import com.example.webapi.database.Kripto
import kotlinx.android.synthetic.main.kartica.view.*



class ItemAdapter(private var podaci: List<Kripto>, private val KlikZaDetalje: KlikZaDetalje, private val mContext: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.kartica, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val podatak = podaci[position]

        val znak = Postavke.getZnak()

        holder.itemView.nazivValute.text = podatak.name
        holder.itemView.simbolValute.text = podatak.symbol
        holder.itemView.rankValute.text = "rank: #" + podatak.rank.toString()
        holder.itemView.cijenaValute.text = "cijena: " + znak + " " + "%,.7f".format(podatak.price?.toDouble()).toString()

        var url: String = podatak.iconUrl!!
        url = url.dropLast(4)
        url += ".png"


        Glide.with(mContext)
            .load(url)
            .fitCenter()
            .placeholder(R.drawable.logo)
            .into(holder.itemView.imageView2)

        holder.itemView.karticaKripto.setOnClickListener{
           KlikZaDetalje.onKriptoItemClicked(position)
        }

    }


    override fun getItemCount() = podaci.size


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setData(updateKriptovaluta: List<Kripto>){
        this.podaci = updateKriptovaluta
        notifyDataSetChanged()
    }

}