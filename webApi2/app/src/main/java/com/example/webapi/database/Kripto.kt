package com.example.webapi.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


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


