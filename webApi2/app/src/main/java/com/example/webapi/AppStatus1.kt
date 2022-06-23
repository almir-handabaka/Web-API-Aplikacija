package com.example.webapi

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log


class AppStatus1 {
    var connectivityManager: ConnectivityManager? = null
    var wifiInfo: NetworkInfo? = null
    var mobileInfo: NetworkInfo? = null
    var connected = false

    val isOnline: Boolean
        get() {
            try {
                connectivityManager = context
                    ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager!!.activeNetworkInfo
                connected = networkInfo != null && networkInfo.isAvailable &&
                        networkInfo.isConnected
                return connected
            } catch (e: Exception) {
                println("CheckConnectivity Exception: " + e.message)
                Log.v("connectivity", e.toString())
            }
            return connected
        }

    companion object {
        val instance = AppStatus1()
        var context: Context? = null
        fun getInstance(ctx: Context): AppStatus1 {
            context = ctx.applicationContext
            return instance
        }

        fun getInstance1(): AppStatus1 {
            return instance
        }
    }
}