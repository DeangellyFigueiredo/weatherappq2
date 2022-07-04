package com.example.appq2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WheaterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addWheater(wheater: Wheater)

    @Query("SELECT * FROM wheater_table ORDER BY id DESC")
    fun readAllData(): LiveData<List<Wheater>>

    @Query("DELETE FROM wheater_table")
    fun deleteAllUser()
}