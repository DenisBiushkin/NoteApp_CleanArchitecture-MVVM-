package com.example.noteapp_cleanarchitect_mvvm.domain.repository

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import java.time.LocalDateTime

interface NoteRepository {

    fun getNotesByDate(dateTime: LocalDateTime):Flow< List<Note>>

    suspend fun getNoteById(noteId:Int):Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}