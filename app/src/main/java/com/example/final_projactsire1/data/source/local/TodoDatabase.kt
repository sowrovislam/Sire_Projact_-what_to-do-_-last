package com.example.final_projactsire1.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.final_projactsire1.data.Task

@Database(entities =[Task::class], version = 1, exportSchema = false )
abstract class TodoDatabase:RoomDatabase() {

abstract fun taskDao():TaskDao

companion object{


    private var database:TodoDatabase?=null

    @Synchronized
    fun gateInstance(contenxt:Context):TodoDatabase{


        if (database==null){

            database=Room.databaseBuilder(contenxt,TodoDatabase::class.java,"task_db").build()

            return database as TodoDatabase
        }
        return database as TodoDatabase
    }

}

}