package com.example.webapi

object Postavke {
    val kategorije = listOf<String>("default", "layer-1", "defi", "stablecoin", "nft", "dex", "exchange", "staking", "dao", "meme", "privacy")
    val valute = listOf<String>("USD", "EUR", "BAM", "GBP", "BTC", "ETH")
    //defi stablecoin nft dex exchange
    //staking dao meme privacy metaverse gaming wrapped layer-1 layer-2
    var selektovana_kategorija = 0
    var selektovana_valuta = 0

    var selektovano_sortiranje = 0


}