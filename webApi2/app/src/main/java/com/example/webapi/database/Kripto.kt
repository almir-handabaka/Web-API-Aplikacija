package com.example.webapi.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "kriptovalute")
data class Kripto(
    @PrimaryKey(autoGenerate = true)
    val kriptoId: Long = 0L,

    @ColumnInfo(name = "naziv_valute")
    val naziv_valute: String,

    @ColumnInfo(name = "simbol_valute")
    val skracenica_valute: String,

    @ColumnInfo(name = "cijena")
    val cijena: Double,

    @ColumnInfo(name = "rank")
    val rank: Int,

    @ColumnInfo(name = "slika")
    val slika: String,

    @ColumnInfo(name = "marketCap")
    val marketCap: Double,

    @ColumnInfo(name = "btcPrice")
    val btcPrice: Double,

    @ColumnInfo(name = "change")
    val change: Double,

    @ColumnInfo(name = "volume24h")
    val volume24h : Double,

)