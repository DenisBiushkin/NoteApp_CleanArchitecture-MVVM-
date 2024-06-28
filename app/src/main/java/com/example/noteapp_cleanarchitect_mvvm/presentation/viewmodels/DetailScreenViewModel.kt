package com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNotesByDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getNotesByDateUseCase: GetNotesByDateUseCase,
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {


}