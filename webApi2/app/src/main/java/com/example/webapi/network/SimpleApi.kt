package com.example.webapi.network


import retrofit2.http.*
import retrofit2.http.GET

interface SimpleApi {

	@Headers("x-access-token: coinrankingf8050d8b73b9974cd10b9fffb5efcbb73eddb185fb354ad9")
	@GET("coins")
	suspend fun getKripto(): Response

	@Headers("x-access-token: coinrankingf8050d8b73b9974cd10b9fffb5efcbb73eddb185fb354ad9")
	@GET("coins")
	suspend fun getSelectedKripto(@Query("referenceCurrencyUuid") referenceValuta: String): Response

	@Headers("x-access-token: coinrankingf8050d8b73b9974cd10b9fffb5efcbb73eddb185fb354ad9")
	@GET("coins")
	suspend fun getSelectedKripto2(@Query("tags[]") kategorije: String, @Query("referenceCurrencyUuid") referenceValuta: String): Response

}