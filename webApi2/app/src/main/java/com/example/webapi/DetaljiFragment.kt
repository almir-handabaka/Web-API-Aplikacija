package com.example.webapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        kriptoNaziv.text = nazivValute
        simbolNaziv.text = simbol
        rankVrijednost.text = rank
        cijenaVrijednost.text = cijena
        marketCapVrijednost.text = marketCap
        btcPriceVrijednost.text = btcPrice
    }

}