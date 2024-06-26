package com.example.final_projactsire1.data.source.local

import com.example.final_projactsire1.data.Task
import com.example.final_projactsire1.data.source.TasksDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(


    private val dao: TaskDao,
    private val ioDispatcher:CoroutineDispatcher=Dispatchers.IO

): TasksDataSource{
    override suspend fun saveTask(task: Task) {

        withContext(ioDispatcher){

            dao.insertTask(task)

        }
    }


}