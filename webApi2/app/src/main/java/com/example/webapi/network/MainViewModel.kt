package com.example.webapi.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webapi.database.KriptoViewModel
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository, var myKriptoViewModel: KriptoViewModel): ViewModel(){
	val myResponse:MutableLiveData<Response> = MutableLiveData()


	fun dohvatiPodatkeSaCoinRanking(kategorija: String, referenceValuta: String){
		Log.i("networklogovanje", referenceValuta)
		try {
			if(kategorija == "default") {
				Log.i("networklogovanje", "default")
				getSelectedKripto(referenceValuta)
			}
			else {
				Log.i("networklogovanje", "getSelectedKripto2")
				getSelectedKripto2(kategorija, referenceValuta)
			}
		} catch(error: Exception){
			Log.i("networklogovanje", "error pri dohvacanju podataka")
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
			Log.i("networklogovanje1", "prije response")
			val response = repository.getSelectedKripto(referenceValuta)
			Log.i("networklogovanje1", "posle response")
			if(response.data.coins.size > 0){

				myKriptoViewModel.clearTable()
				myKriptoViewModel.addBatchKriptos(response.data.coins)
				myResponse.value = response
				Log.i("networklogovanje1", "getSelectedKripto")
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
				Log.i("networklogovanje1", "getSelectedKripto2")
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

//	fun isConnected(): Boolean {
//		val connectivityManager =
//			getSystemService(context.CONNECTIVITY_SERVICE) as ConnectivityManager?
//		val networkInfo = connectivityManager!!.activeNetworkInfo
//		return if (networkInfo != null) {
//			if (networkInfo.isConnected) true else false
//		} else false
//	}


}