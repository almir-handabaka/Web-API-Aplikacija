package com.example.webapi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.webapi.databinding.FragmentPostavkeBinding


class PostavkeFragment : Fragment() {
    lateinit private var mContext: Context

    val vrsteValute = arrayOf("top 50", "layer-1", "DeFi", "Stablecoin", "NFT", "DEX", "Exchange", "Staking", "DAO", "Meme", "Privacy")
    val valute = arrayOf("USD", "EUR", "BAM", "GBP", "BTC", "ETH")


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
        val binding = DataBindingUtil.inflate<FragmentPostavkeBinding>(inflater, com.example.webapi.R.layout.fragment_postavke, container, false)

        val spinnerVrsteValute = binding.spinner
        val spinnerValute = binding.spinner3


        val arraySpinnerVrsteValute = ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, vrsteValute)
        val arraySpinnerValute = ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, valute)




        spinnerVrsteValute.adapter = arraySpinnerVrsteValute
        spinnerValute.adapter = arraySpinnerValute

        spinnerVrsteValute.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(mContext, "izabrana vrsta valute je: " + vrsteValute[p2], Toast.LENGTH_SHORT).show()
                Postavke.selektovana_kategorija = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spinnerValute.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(mContext, "izabrana valuta je: " + valute[p2], Toast.LENGTH_SHORT).show()
                Postavke.selektovana_valuta = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        return binding.root
    }

}