package com.beesham.weatherapp.domain.commands

import com.beesham.weatherapp.domain.dataSource.ForecastProvider
import com.beesham.weatherapp.domain.model.ForecastList

/**
 * Created by Beesham on 2017-09-10.
 */

class RequestForecastCommand(private val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()):
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}