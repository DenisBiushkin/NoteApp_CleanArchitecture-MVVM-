package com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private var _state= mutableStateOf(NoteState())
    val state: State<NoteState> = _state
    val ded= mutableStateOf(0)


    fun GetNotesByDate(date_search: LocalDateTime){

        viewModelScope.launch {
            getNotesByDateUseCase.execute(date_search).collect{
                notes->
                val NotesUI=notes.map {
                    it.toNoteUI()
                }
                state.value.notes=NotesUI
                _state.value=state.value

//                it.forEach{
//                    //Log.d("MyTag", "ID:${it.id} Description:${it.description} Date:${it.date_start}")
//                    Log.d("MyTag", "Start:${it.date_start} Finish:${it.date_finish}")
//                }
            }
        }
    }
    init {
        val date_search = LocalDateTime
            .of(1974, 9, 5,0,0)


    }
}


