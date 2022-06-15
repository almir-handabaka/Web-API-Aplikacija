package com.example.webapi.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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
}
