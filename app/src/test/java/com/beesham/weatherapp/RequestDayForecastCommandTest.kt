package com.beesham.weatherapp

import com.beesham.weatherapp.domain.commands.RequestDayForecastCommand
import com.beesham.weatherapp.domain.dataSource.ForecastProvider
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RequestDayForecastCommandTest {

    @Test
    fun testProviderIsCalled() {
        val forecastProvider = mock(ForecastProvider::class.java)
        val command = RequestDayForecastCommand(2, forecastProvider)

        command.execute()

        verify(forecastProvider).requestForecast(2)
    }
}