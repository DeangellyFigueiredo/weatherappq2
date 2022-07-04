package com.example.appq2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wheater_table")
data class Wheater (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val temp : Double,
    val local: String,
    val sky: String,
    val temp_max: Double,
    val temp_min: Double,
    val feels_like: Double,
    val date: String

)

