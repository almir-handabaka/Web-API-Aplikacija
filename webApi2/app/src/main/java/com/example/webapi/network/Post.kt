package com.example.webapi.network

import com.example.webapi.database.Kripto

data class Coin(
	val uuid: String?,
	val symbol: String?,
	val name: String?,
	val color: String?,
	val iconUrl: String?,
	val marketCap: String?,
	val price: String?,
	val btcPrice: String?,
	val listedAt: Int?,
	val change: String?,
	val rank: Int?,
	val coinrankingUrl: String?,
	val volume24h: String?
)

data class Data(
	val coins: List<Kripto>
)


data class Post (
	val data: Data
)