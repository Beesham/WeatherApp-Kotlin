package com.beesham.weatherapp.domain.commands

/**
 * Created by Beesham on 2017-09-10.
 */

interface Command<out T> {
    fun execute(): T
}
