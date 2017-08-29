package com.beesham.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by Beesham on 8/29/2017.
 */
class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}