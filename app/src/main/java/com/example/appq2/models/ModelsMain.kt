package com.example.appq2.models

 public class ModelsMain {


    val temp : Double
    val feels_like : Double
    val temp_max : Double
    val temp_min : Double
    val pressure: Int
    val humidity: Int

     constructor(
         temp: Double,
         feels_like: Double,
         temp_max: Double,
         temp_min: Double,
         pressure: Int,
         humidity: Int
     ) {
         this.temp = temp
         this.feels_like = feels_like
         this.temp_max = temp_max
         this.temp_min = temp_min
         this.pressure = pressure
         this.humidity = humidity
     }
 }