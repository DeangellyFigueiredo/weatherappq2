package com.example.appq2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Wheater::class], version = 4, exportSchema = false)
abstract class WheaterDatabase :RoomDatabase() {

    abstract fun wheaterDao() : WheaterDao

    companion object{
        @Volatile
        private var INSTANCE: WheaterDatabase?= null

        fun getDatabase(context: Context): WheaterDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WheaterDatabase::class.java,
                    "wheater_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}