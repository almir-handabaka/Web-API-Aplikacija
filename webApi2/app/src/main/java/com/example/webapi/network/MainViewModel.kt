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

// pokusati samo da spasimo stvari u db ako moze, na mjestima gdje nam trebaju podaci kupilo ih direkt iz db

class MainViewModel(private val repository: Repository, var myKriptoViewModel: KriptoViewModel): ViewModel(){
	val myResponse:MutableLiveData<Post> = MutableLiveData()


	fun getPost(){
		if(internetIsConnected()){
			viewModelScope.launch{
				val response = repository.getPost()
				Log.i("networkloging1", response.toString())
				Log.i("networklogovanje", "spasavanje u db")
				myKriptoViewModel.clearTable()
				Log.i("networklogovanje", "addBatchKriptos")
				myKriptoViewModel.addBatchKriptos(response.data.coins)
				Log.i("networklogovanje", "myResponse.value = response")
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