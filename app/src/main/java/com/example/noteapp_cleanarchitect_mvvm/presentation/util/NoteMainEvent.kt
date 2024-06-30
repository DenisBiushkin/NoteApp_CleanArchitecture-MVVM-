package com.example.noteapp_cleanarchitect_mvvm.presentation.util

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note

sealed class NoteMainEvent {

    class AddNewNote(val note: Note):NoteMainEvent()
    class  DeleteNote(val note: Note):NoteMainEvent()

    //class DetatilNote(val note: Note):NoteMainEvent()
    data class ChoiseDate(val choiceTypeDatePicker: ChoiceTypeDatePicker) : NoteMainEvent()


}