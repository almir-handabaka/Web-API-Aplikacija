package com.example.webapi.network


interface SimpleApi {
	@GET("posts/1")
	suspend fun getPost(): Post
}