package com.beesham.weatherapp.domain

public interface Command<out T> {
    fun execute(): T
}