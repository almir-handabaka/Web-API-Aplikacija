package com.example.webapi.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.webapi.database.KriptoViewModel

class MainViewModelFactory(private val repository: Repository, val myKriptoViewModel: KriptoViewModel):ViewModelProvider.Factory{
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return MainViewModel(repository, myKriptoViewModel) as T
	}

}