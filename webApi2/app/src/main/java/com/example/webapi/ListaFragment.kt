package com.example.webapi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webapi.adapter.ItemAdapter
import com.example.webapi.databinding.FragmentListaBinding


class ListaFragment : Fragment(), KlikZaDetalje {



    lateinit private var mContext: Context

    private lateinit var adapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>

    private lateinit var recyclerView: RecyclerView

    val podaci = ArrayList<Podaci>()

    val filteri = arrayOf("najbolji - najgori", "najgori - najbolji", "cijena", "marketcap", "24hvolume")


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
        val binding = DataBindingUtil.inflate<FragmentListaBinding>(inflater, R.layout.fragment_lista, container, false)
        val view = binding.root

        val spinnerFiltera = binding.spinner4

        val arraySpinnerFiltera = ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, filteri)

        spinnerFiltera.adapter = arraySpinnerFiltera

        spinnerFiltera.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(mContext, "izabrana vrsta valute je: " + filteri[p2], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        recyclerView = view.findViewById(R.id.recycler_view)
        kreirajNiz()
        adapter = ItemAdapter(podaci, this)

        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()



        return binding.root
    }

    fun kreirajNiz() {
        for(i in 1..10) {
            podaci.add(Podaci("nazivValute" + i, "simbol" + i, 1, i*i, i*2, i*3, i*4));
        }
    }

    override fun onKriptoItemClicked(position: Int) {
        Log.i("problem", "usao u onKriptoItemClicked");
        val intent = Intent(getActivity(), DetaljiFragment::class.java)
        intent.putExtra("nazivValute", podaci[position].nazivValute)
        intent.putExtra("simbol", podaci[position].simbol)
        intent.putExtra("rank", podaci[position].rank.toString())
        intent.putExtra("cijena", podaci[position].cijena.toString())
        intent.putExtra("marketCap", podaci[position].marketCap.toString())
        intent.putExtra("btcPrice", podaci[position].btcPrice.toString())
        intent.putExtra("volume24h", podaci[position].volume24h.toString())
        startActivity(intent)
    }

}