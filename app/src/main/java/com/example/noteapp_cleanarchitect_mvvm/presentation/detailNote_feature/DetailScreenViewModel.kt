package com.example.noteapp_cleanarchitect_mvvm.presentation.detailNote_feature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNoteByIdUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNotesByDateUseCase
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.NoteState
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.NoteStateDetail
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getNotesByIdUseCase: GetNoteByIdUseCase,
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {

    private var _state= MutableStateFlow(
        NoteStateDetail()
    )
    val state= _state.asStateFlow()

    init {

    }


}