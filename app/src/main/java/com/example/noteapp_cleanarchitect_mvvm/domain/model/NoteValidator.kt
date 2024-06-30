package com.example.noteapp_cleanarchitect_mvvm.domain.model

sealed class NoteValidator {
    data class Error(val messege:String) :NoteValidator()

    data class CorrectNote(val note: Note):NoteValidator()

}