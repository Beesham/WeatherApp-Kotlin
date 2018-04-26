package com.beesham.weatherapp.ui

import android.app.Application
import com.beesham.weatherapp.ui.utils.DelegatesExt

class App: Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}