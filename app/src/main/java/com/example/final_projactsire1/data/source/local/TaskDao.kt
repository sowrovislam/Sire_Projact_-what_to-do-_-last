package com.example.final_projactsire1.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.final_projactsire1.data.Task

@Dao
interface TaskDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)





}