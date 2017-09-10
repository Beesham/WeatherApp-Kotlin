package com.beesham.weatherapp.domain.mappers

import com.beesham.weatherapp.data.Forecast
import com.beesham.weatherapp.data.ForecastResult
import java.text.DateFormat
import java.util.*

/**
 * Created by Beesham on 2017-09-10.
 */

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList =
            ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}