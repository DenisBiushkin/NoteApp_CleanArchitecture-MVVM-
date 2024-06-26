package com.example.noteapp_cleanarchitect_mvvm.domain.use_case

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    suspend fun execute(note: Note){
        repository.insertNote(note = note)
    }
}