package com.example.webapi.network


class Repository {
	suspend fun getPost(): Post{
		return retrofitInstance.api.getPost()
	}

	suspend fun getSelectedPost(tag: String): Post{
		return retrofitInstance.api.getSelectedPost(tag)
	}
}