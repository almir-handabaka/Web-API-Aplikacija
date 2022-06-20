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

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webapi.adapter.ItemAdapter

import com.example.webapi.database.Kripto
import com.example.webapi.database.KriptoViewModel
import com.example.webapi.databinding.FragmentListaBinding
import com.example.webapi.network.MainViewModel
import com.example.webapi.network.MainViewModelFactory
import com.example.webapi.network.Repository



class ListaFragment : Fragment(), KlikZaDetalje {

    private lateinit var viewModel: MainViewModel
    private lateinit var  myKriptoViewModel: KriptoViewModel

    lateinit private var mContext: Context

    private lateinit var adapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>

    private lateinit var recyclerView: RecyclerView

    var podaci = listOf<Kripto>()

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


        // api i db
        myKriptoViewModel = ViewModelProvider(this).get(KriptoViewModel::class.java)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository, myKriptoViewModel)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.dohvatiPodatkeSaCoinRanking(Postavke.kategorije[Postavke.selektovana_kategorija])



        val spinnerFiltera = binding.spinner4

        val arraySpinnerFiltera = ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, filteri)

        spinnerFiltera.adapter = arraySpinnerFiltera

        spinnerFiltera.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(mContext, "izabrana vrsta valute je: " + filteri[p2], Toast.LENGTH_SHORT).show()
                Postavke.selektovano_sortiranje = p2
                binding.izracunajPut.setOnClickListener {
                    sortiraj()
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        recyclerView = view.findViewById(R.id.recycler_view)

        //kreirajNiz()
        adapter = ItemAdapter(podaci, this, mContext)


        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()

        myKriptoViewModel.readAllData.observe(viewLifecycleOwner, Observer {grad ->
            Log.i("networklogovanje3", grad.size.toString())

            podaci = grad
            (adapter as ItemAdapter).setData(grad)
        })


        return binding.root
    }


    override fun onKriptoItemClicked(position: Int) {
        Log.i("networklogovanje4", "usao u onKriptoItemClicked");
        Log.i("networklogovanje4", podaci.size.toString())
        val intent = Intent(getActivity(), DetaljiFragment::class.java)
        intent.putExtra("nazivValute", podaci[position].name)
        intent.putExtra("simbol", podaci[position].symbol)
        intent.putExtra("rank", podaci[position].rank.toString())
        intent.putExtra("cijena", podaci[position].price.toString())

        intent.putExtra("marketCap", podaci[position].marketCap.toString())
        intent.putExtra("btcPrice", podaci[position].btcPrice.toString())
        intent.putExtra("volume24h", podaci[position].volume24h.toString())
        startActivity(intent)
    }

    // sortiramo podaci i preko setData updatujemo recyclerview
    fun sortiraj(){
        // "najbolji - najgori", "najgori - najbolji", "cijena", "marketcap", "24hvolume"
        Log.i("sortiranje", "Ulaz u funkciju")
        val uslov = Postavke.selektovano_sortiranje
        var tmp_podaci = podaci.toMutableList()

        if(uslov == 0 || uslov == 1){
            tmp_podaci.sortBy { it.rank }
            if(uslov == 1){
                tmp_podaci.reverse()
            }
        }
        else if(uslov == 2){
            tmp_podaci.sortBy { it.price?.toDouble() }
            tmp_podaci.reverse()
        }
        else if(uslov == 3){
            tmp_podaci.sortBy { it.marketCap?.toDouble() }
            tmp_podaci.reverse()
        }
        else{
            tmp_podaci.sortBy { it.volume24h }
            tmp_podaci.reverse()
        }

        Log.i("sortiranje", "setData")
        podaci = tmp_podaci
        (adapter as ItemAdapter).setData(tmp_podaci)


    }

}