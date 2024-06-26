package com.example.final_projactsire1.data.source

import com.example.final_projactsire1.data.Task


interface TasksDataSource {

    suspend fun saveTask(task: Task)




}