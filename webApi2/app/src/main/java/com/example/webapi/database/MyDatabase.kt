package com.example.webapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Kripto::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {


    abstract fun kriptoDao(): KriptoDao

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "moja_databaza"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }


                return instance
            }
        }
    }
}