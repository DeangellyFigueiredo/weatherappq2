package com.example.appq2.models

import android.graphics.ColorSpace

class ResponseWheater {
    val coord: Coord
    val weather : List<Wheatermodel>
    val base: String
    val main: ModelsMain
    val visibility: Double
    val wind : Wind
    val clouds : Cloud
    val dt: Double
    val sys: Sys
    val timezone: Double
    val id: Double
    val name: String
    val cod: Double

    constructor(
        coord: Coord,
        weather: List<Wheatermodel>,
        base: String,
        main: ModelsMain,
        visibility: Double,
        wind: Wind,
        clouds: Cloud,
        dt: Double,
        sys: Sys,
        timezone: Double,
        id: Double,
        name: String,
        cod: Double
    ) {
        this.coord = coord
        this.weather = weather
        this.base = base
        this.main = main
        this.visibility = visibility
        this.wind = wind
        this.clouds = clouds
        this.dt = dt
        this.sys = sys
        this.timezone = timezone
        this.id = id
        this.name = name
        this.cod = cod
    }
}