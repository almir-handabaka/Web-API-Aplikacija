package com.example.webapi.database

import android.content.Context
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.webapi.database.Kripto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KriptoViewModel(application: Application): AndroidViewModel(application) {
    lateinit var readAllData: LiveData<List<Kripto>>
    private val repository: KriptoRepository
    init {
        val kriptoDao = MyDatabase.getInstance(application).kriptoDao()

        repository = KriptoRepository(kriptoDao)
        readAllData = repository.readAllData
    }

    fun addKripto(kripto: Kripto){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNewKripto(kripto)
        }
    }

    fun addBatchKriptos(kriptos: List<Kripto>){
        viewModelScope.launch(Dispatchers.IO){
            repository.BatchInsert(kriptos)
        }
    }

    fun clearTable(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }


    fun getKriptoById(id:Long): Kripto? {
        var g:Kripto? = null
        viewModelScope.launch(Dispatchers.IO){
            g =  repository.getKriptoById(id)
        }
        return g
    }
}
