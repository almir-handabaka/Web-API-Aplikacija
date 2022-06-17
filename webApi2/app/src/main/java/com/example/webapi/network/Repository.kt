package com.example.webapi.network


class Repository {
	suspend fun getPost(): Post{
		return retrofitInstance.api.getPost()
	}
}