package com.example.webapi.network


class Repository {
	suspend fun getKripto(): Response{
		return retrofitInstance.api.getKripto()
	}

	suspend fun getSelectedKripto(referenceValuta: String): Response{
		return retrofitInstance.api.getSelectedKripto(referenceValuta)
	}

	suspend fun getSelectedKripto2(kategorija: String, referenceValuta: String): Response{
		return retrofitInstance.api.getSelectedKripto2(kategorija, referenceValuta)
	}
}