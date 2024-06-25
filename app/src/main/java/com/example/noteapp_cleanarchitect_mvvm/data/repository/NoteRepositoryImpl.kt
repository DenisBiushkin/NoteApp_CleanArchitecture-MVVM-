package com.example.noteapp_cleanarchitect_mvvm.data.repository

import com.example.noteapp_cleanarchitect_mvvm.data.data_source.NoteDao
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Instant

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override suspend fun getNotesByDate(date: Instant):Flow <List<Note>> {
        return flow {
            emit(dao.getNotesByDate())
        }
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note=note)
    }
}