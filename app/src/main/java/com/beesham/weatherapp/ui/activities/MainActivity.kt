package com.beesham.weatherapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.beesham.weatherapp.R
import com.beesham.weatherapp.data.ForecastRequest
import com.beesham.weatherapp.domain.commands.RequestForecastCommand
import com.beesham.weatherapp.domain.model.Forecast
import com.beesham.weatherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.item_forecast.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = findViewById<RecyclerView>(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { forecast ->  toast(forecast.date) }
                forecastList.adapter = adapter
            }
        }
    }
}
