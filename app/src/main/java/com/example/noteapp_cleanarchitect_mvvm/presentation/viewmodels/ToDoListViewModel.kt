package com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val repository: NoteRepository
):ViewModel() {


    init {
        viewModelScope.launch {
            repository.insertNote(Note(name = "By telephone", description = "Buy samsumg s23"))
            repository.getNotesByDate(Instant.now()).collect{

                Log.d("MyTag", it[0].description)
            }




        }
    }
}


