package com.example.noteapp_cleanarchitect_mvvm.presentation.viewmodels

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI

class NoteState (
    val notes:List<NoteUI> = emptyList()
)