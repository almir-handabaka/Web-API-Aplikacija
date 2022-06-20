package com.example.webapi.network


import retrofit2.http.*

import retrofit2.http.GET

interface SimpleApi {
	@GET("coins")
	suspend fun getPost(): Post

	@GET("coins")
	suspend fun getSelectedPost(@Query("tags[]") noviTag1: String): Post

}