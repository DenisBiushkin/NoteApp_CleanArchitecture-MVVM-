package com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNotesByDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getNotesByDateUseCase: GetNotesByDateUseCase,
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {

    val listNotes = listOf(
       Note(
            name = "Awake",
            description = "Почистить зубы",
            date_start= LocalDateTime.of(2024, 6, 26,7,0),
            date_finish = LocalDateTime.of(2024, 6, 26,8,0)
        ),
        Note(
            name = "Working",
            description = "Сделать задание по практике",
            date_start= LocalDateTime.of(2024, 6, 26,9,0),
            date_finish = LocalDateTime.of(2024, 6, 26,10,0)
        ),
        Note(
            name = "Eating",
            description = "Покушать",
            date_start= LocalDateTime.of(2024, 6, 26,10,0),
            date_finish = LocalDateTime.of(2024, 6, 26,14,0)
        ),
        /////
        Note(
            name = "Sleep",
            description = "Поспать",
            date_start= LocalDateTime.of(2024, 6, 27,0,0),
            date_finish = LocalDateTime.of(2024, 6, 27,10,0)
        ),
        Note(
            name = "Chill",
            description = "Отдохнуть",
            date_start= LocalDateTime.of(2024, 6, 27,10,0),
            date_finish = LocalDateTime.of(2024, 6, 27,11,0)
        ),
        Note(
            name = "Hard working",
            description = "Лютый воркинг над заданием по практике",
            date_start= LocalDateTime.of(2024, 6, 27,11,0),
            date_finish = LocalDateTime.of(2024, 6, 27,18,0)
        ),
    )
    suspend fun initdatabase1(){
//        repository.insertNote(listNotes[3])
//        repository.insertNote(listNotes[4])
//        repository.insertNote(listNotes[5])
    }
    init {
        val date_search = LocalDateTime
            .of(1974, 9, 5,0,0)

        viewModelScope.launch {

            getNotesByDateUseCase.execute(date_search).collect{
                it.forEach{
                //Log.d("MyTag", "ID:${it.id} Description:${it.description} Date:${it.date_start}")
                    Log.d("MyTag", "Start:${it.date_start} Finish:${it.date_finish}")
                }
             }
        }
    }
}


