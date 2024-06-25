package com.example.noteapp_cleanarchitect_mvvm.domain.repository

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import kotlinx.coroutines.flow.Flow
import java.time.Instant

interface NoteRepository {

    suspend fun getNotesByDate(date: Instant): List<Note>
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}