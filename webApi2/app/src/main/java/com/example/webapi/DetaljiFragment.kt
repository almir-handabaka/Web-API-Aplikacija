package com.example.webapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.fragment.navArgs
import com.example.webapi.databinding.FragmentDetaljiBinding
import com.example.webapi.databinding.FragmentListaBinding
import kotlinx.android.synthetic.main.fragment_detalji.*


class DetaljiFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detalji)

        val nazivValute = intent.getStringExtra("nazivValute")
        val simbol = intent.getStringExtra("simbol")
        val rank = intent.getStringExtra("rank")
        val cijena = intent.getStringExtra("cijena")
        val marketCap = intent.getStringExtra("marketCap")
        val btcPrice = intent.getStringExtra("btcPrice")
        val volume24h = intent.getStringExtra("volume24h")

        kriptoNaziv.text = nazivValute
        simbolNaziv.text = simbol
        rankVrijednost.text = rank
        cijenaVrijednost.text = cijena
        marketCapVrijednost.text = marketCap
        btcPriceVrijednost.text = btcPrice
        volume24hVrijednost.text = volume24h
    }

}