package com.example.webapi.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
	val uuid: String?,
	val symbol: String?,
	val name: String?,
	val color: String?,
	val iconUrl: String?,
	val marketCap: String?,
	val price: String?,
	val btcPrice: String?,
	val listedAt: Int?,
	val change: String?,
	val rank: Int?,
	val coinrankingUrl: String?,
	val volume24h: String?
 */



@Entity(tableName = "kriptovalute")
data class Kripto(
    @PrimaryKey(autoGenerate = true)
    val kriptoId: Long = 0L,

    @ColumnInfo(name = "uuid")
    val uuid: String?,

    @ColumnInfo(name = "symbol")
    val symbol: String?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "color")
    val color: String?,

    @ColumnInfo(name = "iconUrl")
    val iconUrl: String?,

    @ColumnInfo(name = "marketCap")
    val marketCap: String?,

    @ColumnInfo(name = "price")
    val price: String?,

    @ColumnInfo(name = "btcPrice")
    val btcPrice: String?,

    @ColumnInfo(name = "listedAt")
    val listedAt: Int?,

    @ColumnInfo(name = "change")
    val change: String?,

    @ColumnInfo(name = "rank")
    val rank: Int?,

    @ColumnInfo(name = "coinrankingUrl")
    val coinrankingUrl: String?,

    @ColumnInfo(name = "volume24h")
    val volume24h: String?,
    )



/*
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

)*/
