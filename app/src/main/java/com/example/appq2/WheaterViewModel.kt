package com.example.appq2

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appq2.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class WheaterViewModel(application: Application):AndroidViewModel(application){

     val readAllData: LiveData<List<Wheater>>
    private val repository: WheatersRepository

    init {
        val wheaterDao = WheaterDatabase.getDatabase(application).wheaterDao()
        repository = WheatersRepository(wheaterDao)
        readAllData = repository.realAllData
    }

    fun addWheater(wheater: Wheater){

        viewModelScope.launch(Dispatchers.IO) {
            repository.addWheater(wheater)
        }
    }

    fun deleteAllWheater(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllWheater()
        }
    }

}