package com.example.webapi.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webapi.AppStatus1
import com.example.webapi.database.KriptoViewModel
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository, var myKriptoViewModel: KriptoViewModel): ViewModel(){
	val myResponse:MutableLiveData<Response> = MutableLiveData()




	fun dohvatiPodatkeSaCoinRanking(kategorija: String, referenceValuta: String) {

		if (AppStatus1.getInstance1().isOnline) {
			Log.i("networklogovanje55", "wifi online")

			try {
				if (kategorija == "default") {
					getSelectedKripto(referenceValuta)
				} else {
					getSelectedKripto2(kategorija, referenceValuta)
				}
			} catch (error: Exception) {
				Log.i("networklogovanje", "error pri dohvacanju podataka")
			}

		} else {
			Log.i("networklogovanje55", "wifi offline")
		}

	}



	fun getKripto(){
			viewModelScope.launch{
				val response = repository.getKripto()
				if(response.data.coins.size > 0){
					myKriptoViewModel.clearTable()
					myKriptoViewModel.addBatchKriptos(response.data.coins)
					myResponse.value = response
				}
			}


	}

	fun getSelectedKripto(referenceValuta: String){
		viewModelScope.launch{
			val response = repository.getSelectedKripto(referenceValuta)
			if(response.data.coins.size > 0){
				Log.i("networklogovanje51", response.data.coins.size.toString())
				myKriptoViewModel.clearTable()
				myKriptoViewModel.addBatchKriptos(response.data.coins)
				myResponse.value = response
			}
		}
	}

	fun getSelectedKripto2(kategorija:String, referenceValuta:String){
		viewModelScope.launch{
			val response = repository.getSelectedKripto2(kategorija, referenceValuta)
			if(response.data.coins.size > 0){
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