package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker

sealed class NoteMainEvent {

    class  DeleteNote(val note: NoteUI): NoteMainEvent()

    data class ChangeDatePickerState(val choiceTypeDatePicker: ChoiceTypeDatePicker) : NoteMainEvent()


}