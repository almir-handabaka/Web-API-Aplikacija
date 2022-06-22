package com.example.webapi.network

import com.example.webapi.database.Kripto
import com.squareup.moshi.Json

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
	@field:Json(name = "24hVolume") val volume24h: String?
)

data class Data(
	val coins: List<Kripto>
)


data class Response (
	val data: Data
)