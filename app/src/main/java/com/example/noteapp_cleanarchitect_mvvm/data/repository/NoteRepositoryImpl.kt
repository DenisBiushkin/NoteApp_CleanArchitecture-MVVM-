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
    private val dao: NoteDao
): NoteRepository {



    override suspend fun getNotesByDate(datetime:LocalDateTime):Flow <List<Note>> {
       // val date=datetime.toEpochSecond(ZoneOffset.UTC)

        return flow {
            emit(dao.getNotesByDate(datetime))
        }
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note=note)
    }
}