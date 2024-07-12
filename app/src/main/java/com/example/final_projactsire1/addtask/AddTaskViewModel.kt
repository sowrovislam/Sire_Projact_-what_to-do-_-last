package com.example.final_projactsire1.addtask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_projactsire1.R
import com.example.final_projactsire1.data.Task
import com.example.final_projactsire1.data.source.DefaultTaskRepository
import com.example.final_projactsire1.data.source.local.LocalDataSource
import com.example.final_projactsire1.utils.toTimedString
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AddTaskViewModel(private val application: Application):AndroidViewModel(application) {

    val title=MutableLiveData<String>()

    val description=MutableLiveData<String>()

    val repsitory:DefaultTaskRepository=DefaultTaskRepository.gateInstens(application)

    private val _snackbarMsg=MutableLiveData<Int>()

    val snakbarMsg: LiveData<Int>

        get() = _snackbarMsg


    private val tittleLength=6








    fun saveTask() {
        val currentTitle = title.value
        val currentDescription = description.value



         if ( isValidTask(currentTitle,currentDescription)){

             val task =
                 Task(title = currentTitle.toTimedString(), description = currentDescription.toTimedString())
             createTask(task)
         }



    }

    private fun isValidTask(currentTitle: String?, currentDescription: String?):Boolean {

        if (currentTitle.isNullOrEmpty()||currentDescription.isNullOrEmpty()){

            _snackbarMsg.postValue(R.string.empty_task_message)


            return false

        }

        if (currentTitle.toString().length<tittleLength){

            _snackbarMsg.postValue(R.string.tittlemast_be_6_char)

            return false
        }


    return true
    }

    private fun createTask(task: Task) {

        viewModelScope.launch {
            repsitory.saveTask(task)
        }

    }

}