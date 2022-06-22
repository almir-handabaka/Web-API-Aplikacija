package com.example.webapi

object Postavke {
    val kategorije = listOf<String>("default", "layer-1", "defi", "stablecoin", "nft", "dex", "exchange", "staking", "dao", "meme", "privacy")
    val valute = listOf<String>("yhjMzLPhuIDl", "5k-_VTxqtCEI", "oEQyEhEFWdeLe", "Hokyui45Z38f", "Qwsogvtv82FCd", "razxDUgYGNAdQ")


    var selektovana_kategorija = 0
    var selektovana_valuta = 0

    var selektovano_sortiranje = 0


    fun getZnak() : String {
        if(selektovana_valuta == 0) {
            return "$"
        }
        else if(selektovana_valuta == 1) {
            return "€"
        }
        else if(selektovana_valuta == 2) {
            return "BAM"
        }
        else if(selektovana_valuta == 3) {
            return "£"
        }
        else if(selektovana_valuta == 4) {
            return "BTC"
        }
        else {
            return "ETH"
        }
    }

}