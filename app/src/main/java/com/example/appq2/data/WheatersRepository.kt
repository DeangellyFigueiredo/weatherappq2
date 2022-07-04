package com.example.appq2.data

import androidx.lifecycle.LiveData

class WheatersRepository (private val wheaterDao : WheaterDao) {

    val realAllData: LiveData<List<Wheater>> = wheaterDao.readAllData()

    suspend fun  addWheater(wheater: Wheater){
        wheaterDao.addWheater(wheater)
    }

    suspend fun deleteAllWheater(){
        wheaterDao.deleteAllUser()
    }
}