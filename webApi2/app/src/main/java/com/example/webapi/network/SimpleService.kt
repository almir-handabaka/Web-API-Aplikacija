//package com.example.webapi.network
//
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.Headers
//import retrofit2.http.Query
//
//enum class MarsApiFilter(val value: String) {
//    SHOW_RENT("rent"),
//    SHOW_BUY("buy"),
//    SHOW_ALL("all") }
//
//private const val BASE_URL = "https://api.coinranking.com/"
//
//
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()
//
//interface SimpleService {
//
//    @Headers("x-access-token: coinrankingf8050d8b73b9974cd10b9fffb5efcbb73eddb185fb354ad9")
//    @GET("v2/coins")
//    suspend fun getProperties(@Query("filter") type: String): List<KriptoValuta>
//}
//
///**
// * A public Api object that exposes the lazy-initialized Retrofit service
// */
//object SimpleServiceApi {
//    val retrofitService : SimpleService by lazy { retrofit.create(SimpleService::class.java) }
//}
//
//
