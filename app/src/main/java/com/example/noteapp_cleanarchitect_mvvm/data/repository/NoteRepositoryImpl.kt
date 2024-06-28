package com.example.noteapp_cleanarchitect_mvvm.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.noteapp_cleanarchitect_mvvm.data.data_source.NoteDao
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class NoteRepositoryImpl(
    private val database:NoteDao
): NoteRepository {
    override suspend fun getNoteById(noteId: Int): Note? {
        return database.getNoteById(noteId)
    }

    override fun getNotesByDate(datetime:LocalDateTime):Flow <List<Note>> {
       // val date=datetime.toEpochSecond(ZoneOffset.UTC)
        return database.getNotesByDate(datetime)
    }

    override suspend fun insertNote(note: Note) {
        database.insertNote(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        database.deleteNote(note=note)
    }
}