package com.example.noteapp_cleanarchitect_mvvm.presentation.detailNote_feature

import androidx.lifecycle.ViewModel
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNoteByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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