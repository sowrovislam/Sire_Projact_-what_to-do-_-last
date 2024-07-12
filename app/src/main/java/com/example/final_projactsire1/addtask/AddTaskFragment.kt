package com.example.final_projactsire1.addtask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel

import com.example.final_projactsire1.R
import com.example.final_projactsire1.databinding.FragmentAddTaskBinding
import com.example.final_projactsire1.utils.showChar
import com.example.final_projactsire1.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding

    private val  viewModel by viewModels<AddTaskViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding =DataBindingUtil.inflate(inflater, R.layout.fragment_add_task, container, false)

        binding.viewmodel=viewModel

        binding.lifecycleOwner=this.viewLifecycleOwner


        bindUiMessage()



        addTask()




        return binding.root




    }

    private fun addTask() {



    }
    private fun bindUiMessage() {
        binding.warningTextTaskTitle.showChar(lifecycleOwner = viewLifecycleOwner, viewModel.title)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindSnakbar(view)
    }

    private fun bindSnakbar(view: View) {
        view.showSnackbar(
            lifecycleOwner = viewLifecycleOwner,
            viewModel.snakbarMsg,
            Snackbar.LENGTH_LONG)

    }


}