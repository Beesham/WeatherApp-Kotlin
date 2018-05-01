package com.beesham.weatherapp.domain.commands

import com.beesham.weatherapp.domain.dataSource.ForecastProvider
import com.beesham.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}