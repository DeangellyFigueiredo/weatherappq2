package com.example.appq2.models

class Sys {
    val type: Double
    val id: Double
    val country: String
    val sunrise: Double
    val sunset: Double

    constructor(type: Double, id: Double, country: String, sunrise: Double, sunset: Double) {
        this.type = type
        this.id = id
        this.country = country
        this.sunrise = sunrise
        this.sunset = sunset
    }
}