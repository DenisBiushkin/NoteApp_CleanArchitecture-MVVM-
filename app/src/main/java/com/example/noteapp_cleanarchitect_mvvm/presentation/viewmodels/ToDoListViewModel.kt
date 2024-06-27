package com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNotesByDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getNotesByDateUseCase: GetNotesByDateUseCase,
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {

    private var _state= MutableStateFlow(NoteState())

    val state= _state.asStateFlow()

    fun GetNotesByDate(date_search: LocalDateTime){

        viewModelScope.launch {
            getNotesByDateUseCase.execute(date_search).collect{
                notes->
                val NotesUI=notes.map {
                    it.toNoteUI()
                }
                _state.value=NoteState(notes=NotesUI)
            }
        }
    }
    init {
        val date_search = LocalDateTime
            .of(2024, 6, 26,0,0)
        GetNotesByDate(date_search)

    }
}


