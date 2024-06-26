package com.example.noteapp_cleanarchitect_mvvm.domain.use_case

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime


class GetNotesByDateUseCase(
    private val repository: NoteRepository
) {
     fun execute(dateTime: LocalDateTime): Flow<List<Note>>{
        return repository.getNotesByDate(dateTime = dateTime)
    }
}