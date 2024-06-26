package com.example.final_projactsire1.addtask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_projactsire1.data.Task
import com.example.final_projactsire1.data.source.DefaultTaskRepository
import com.example.final_projactsire1.data.source.local.LocalDataSource
import kotlinx.coroutines.launch

class AddTaskViewModel(application: Application):AndroidViewModel(application) {

    val title=MutableLiveData<String>()

    val description=MutableLiveData<String>()

    val repsitory:DefaultTaskRepository=DefaultTaskRepository.gateInstens(application)

    fun saveTask() {
        val currentTitle = title.value
        val currentDescription = description.value
        val task =
            Task(title = currentTitle.toString(), description = currentDescription.toString())
        createTask(task)
    }

    private fun createTask(task: Task) {

        viewModelScope.launch {
            repsitory.saveTask(task)
        }

    }

}