package com.beesham.weatherapp.domain.model

/**
 * Created by Beesham on 2017-09-10.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)