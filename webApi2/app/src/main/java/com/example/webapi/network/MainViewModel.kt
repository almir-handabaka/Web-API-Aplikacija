package com.example.webapi.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.webapi.database.Kripto
import com.example.webapi.database.KriptoViewModel
import kotlinx.coroutines.launch
import retrofit2.http.GET


class MainViewModel(private val repository: Repository, var myKriptoViewModel: KriptoViewModel): ViewModel(){
	val myResponse:MutableLiveData<Post> = MutableLiveData()

	fun getPost(){
		if(internetIsConnected()){
			viewModelScope.launch{
				val response = repository.getPost()
				myKriptoViewModel.clearTable()
				myKriptoViewModel.addBatchKriptos(response.data.coins)
				myResponse.value = response
			}
		}

	}

	fun internetIsConnected(): Boolean {
		return try {
			val command = "ping -c 1 google.com"
			Runtime.getRuntime().exec(command).waitFor() == 0
		} catch (e: Exception) {
			false
		}
	}
}