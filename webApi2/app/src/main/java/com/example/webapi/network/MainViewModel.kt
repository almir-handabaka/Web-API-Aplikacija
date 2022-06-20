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


	fun dohvatiPodatkeSaCoinRanking(kategorija: String){
		if (kategorija == "default"){
			Log.i("networklogovanje", "default")
			getPost()
		}
		else {
			Log.i("networklogovanje", "getSelectedPost")
			getSelectedPost(kategorija)
		}
	}


	fun getPost(){
		//if(internetIsConnected()){
			Log.i("networklogovanje", "ima neta")
			viewModelScope.launch{
				val response = repository.getPost()
				if(response.data.coins.size > 0){
					myKriptoViewModel.clearTable()

				}
				Log.i("networklogovanje3", response.data.toString())
				myKriptoViewModel.addBatchKriptos(response.data.coins)
				myResponse.value = response
			}
		//} else {
		//	Log.i("networklogovanje", "nema neta")
		//}

	}

	fun getSelectedPost(tag:String){
		//if(internetIsConnected()){
		Log.i("networklogovanje", "ima neta")
		viewModelScope.launch{
			val response = repository.getSelectedPost(tag)
			myKriptoViewModel.clearTable()
			myKriptoViewModel.addBatchKriptos(response.data.coins)
			myResponse.value = response
		}
		//} else {
		//	Log.i("networklogovanje", "nema neta")
		//}

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