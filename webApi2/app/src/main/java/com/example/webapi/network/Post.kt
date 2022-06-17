package com.example.webapi.network

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
	val coins: List<Coin>
)


data class Post (
	val status: String,
	val data: Data
)