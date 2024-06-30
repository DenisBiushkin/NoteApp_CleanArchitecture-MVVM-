package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import java.time.LocalDate

class NoteState (
    val notes:List<NoteUI> = emptyList(),
    val currentDay_format: CurrentDay,
    val currentDay: LocalDate
)