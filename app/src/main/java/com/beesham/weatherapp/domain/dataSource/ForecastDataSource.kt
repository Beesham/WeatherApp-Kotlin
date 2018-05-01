package com.beesham.weatherapp.domain.dataSource

import com.beesham.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}