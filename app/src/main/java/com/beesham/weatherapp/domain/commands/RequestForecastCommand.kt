package com.beesham.weatherapp.domain.commands

import com.beesham.weatherapp.data.ForecastRequest
import com.beesham.weatherapp.domain.mappers.ForecastDataMapper
import com.beesham.weatherapp.domain.model.ForecastList

/**
 * Created by Beesham on 2017-09-10.
 */

class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}