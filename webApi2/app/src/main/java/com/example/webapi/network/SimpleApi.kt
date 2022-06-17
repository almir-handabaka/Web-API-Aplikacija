package com.example.webapi.network

import retrofit2.http.GET

interface SimpleApi {
	@GET("coins")
	suspend fun getPost(): Post
}