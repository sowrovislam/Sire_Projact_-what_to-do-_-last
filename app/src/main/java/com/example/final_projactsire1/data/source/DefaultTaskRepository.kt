package com.example.final_projactsire1.data.source

import android.app.Application
import com.example.final_projactsire1.data.Task
import com.example.final_projactsire1.data.source.local.LocalDataSource
import com.example.final_projactsire1.data.source.local.TodoDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DefaultTaskRepository private constructor(application: Application){

    private val localDataSource:LocalDataSource
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    init {

        localDataSource=LocalDataSource(TodoDatabase.gateInstance(application).taskDao())



    }

    companion object{


        private var repository:DefaultTaskRepository?=null


        @Synchronized
        fun gateInstens(application: Application):DefaultTaskRepository{


            if (repository==null){

                repository=DefaultTaskRepository(application)
                return repository as DefaultTaskRepository
            }


            return repository as DefaultTaskRepository




        }





    }

    suspend fun saveTask(task: Task){

       withContext(ioDispatcher){

           localDataSource.saveTask(task)
       }

    }
}