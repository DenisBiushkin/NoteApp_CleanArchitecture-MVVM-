package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker

sealed class NoteMainEvent {

    class AddNewNote(val note: Note): NoteMainEvent()
    class  DeleteNote(val note: Note): NoteMainEvent()

    //class DetatilNote(val note: Note):NoteMainEvent()
    data class ChoiseDate(val choiceTypeDatePicker: ChoiceTypeDatePicker) : NoteMainEvent()


}