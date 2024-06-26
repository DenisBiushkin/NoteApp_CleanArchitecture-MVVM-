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
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val repository: NoteRepository
):ViewModel() {


    init {
        val date= LocalDateTime
            .of(1974, 9, 5,11,0)
        viewModelScope.launch {

            repository.insertNote(Note(
                name = "By telephone",
                description = "Buy samsumg s23",
//                birthday = Date(1974),
                 date_start =date,
                 date_finish = date
            ))
//             repository.getNotesByDate(date).collect{
//             it.forEach{
//             Log.d("MyTag", "ID:${it.id} Description:${it.description}")
//             }
//             }
        }
    }
}


