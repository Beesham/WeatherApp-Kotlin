package com.beesham.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.beesham.weatherapp.R
import com.beesham.weatherapp.domain.model.Forecast
import com.beesham.weatherapp.domain.model.ForecastList
import com.beesham.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by Beesham on 8/28/2017.
 */

class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                //Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high} \u00B0"
                minTemperatureView.text = "${low} \u00B0"
                itemView.setOnClickListener { itemClick(this)}

            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}