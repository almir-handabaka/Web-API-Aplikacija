package com.example.webapi.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.http.GET

class MainViewModel(private val repository: Repository): ViewModel(){
	val myResponse:MutableLiveData<Post> = MutableLiveData()

	fun getPost(){
		viewModelScope.launch{
			val response = repository.getPost()
			Log.i("networkloging1", response.toString())
			myResponse.value = response
		}
	}
}