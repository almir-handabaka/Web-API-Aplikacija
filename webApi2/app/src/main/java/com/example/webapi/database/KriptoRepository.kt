package com.example.webapi.database

import androidx.lifecycle.LiveData

class KriptoRepository (private val kriptoDao: KriptoDao){
    val readAllData: LiveData<List<Kripto>> = kriptoDao.getAllKriptos()

    suspend fun addNewKripto(kripto:Kripto){
        kriptoDao.addKripto(kripto)
    }

    suspend fun getKriptoById(id:Long): Kripto? {
        return kriptoDao.get(id)
    }

    suspend fun getAllKripto(): LiveData<List<Kripto>>{
        return kriptoDao.getAllKriptos()
    }

    suspend fun BatchInsert(kriptos: List<Kripto>){
        kriptoDao.insertAll(kriptos)
    }

    suspend fun deleteAll(){
         kriptoDao.clear()
    }
}
