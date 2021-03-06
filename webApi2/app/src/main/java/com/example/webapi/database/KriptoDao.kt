package com.example.webapi.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface KriptoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addKripto(kripto: Kripto)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(kriptos: List<Kripto>)

    @Update
    suspend  fun update(kripto: Kripto)


    @Query("SELECT * from kriptovalute WHERE kriptoId = :key")
    suspend fun get(key: Long): Kripto?

    @Query("DELETE FROM kriptovalute")
    suspend fun clear()

    @Query("SELECT * FROM kriptovalute ORDER BY kriptoId ASC")
     fun getAllKriptos(): LiveData<List<Kripto>>

    @Query("SELECT * FROM kriptovalute ORDER BY kriptoId DESC LIMIT 1")
    suspend fun getKripto(): Kripto?
}