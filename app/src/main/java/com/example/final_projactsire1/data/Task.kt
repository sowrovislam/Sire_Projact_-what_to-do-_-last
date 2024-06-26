package com.example.final_projactsire1.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val description:String,
    val isComplited:Boolean=false


){

val isActive
    get()=!isComplited

    val isEmpty
        get() = title.isEmpty()||description.isEmpty()





}