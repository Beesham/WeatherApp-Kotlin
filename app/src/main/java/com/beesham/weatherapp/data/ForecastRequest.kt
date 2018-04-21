package com.beesham.weatherapp.data

import com.google.gson.Gson
import java.net.URL

class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = ""
        private val URL = ""
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}