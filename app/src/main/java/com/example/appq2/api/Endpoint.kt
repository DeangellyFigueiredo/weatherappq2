package com.example.appq2.api

import android.telecom.Call
import androidx.room.Delete
import com.example.appq2.models.ResponseWheater
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {
    @GET("/data/2.5/weather?q=Manaus&units=metric&appid=a4afb8143f0ddd005e6506aa59c81e6d")
    fun getCurrencies() : retrofit2.Call<ResponseWheater>

    @GET("/data/2.5/weather?&units=metric&appid=a4afb8143f0ddd005e6506aa59c81e6d")
    fun getCurrencieslocal(@Query("q") location : String) : retrofit2.Call<ResponseWheater>


}