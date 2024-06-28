package com.example.noteapp_cleanarchitect_mvvm.domain.use_case

import androidx.compose.ui.unit.Constraints
import com.example.noteapp_cleanarchitect_mvvm.data.repository.NoteRepositoryImpl
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.Resource
import com.example.noteapp_cleanarchitect_mvvm.util.Constans
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import java.time.LocalDateTime
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend fun execute(noteId:Int): Flow<Resource<Note>> {
        return flow {
            try {
                emit(Resource.Loading())
                val note = repository.getNoteById(noteId)?: Constans.noteError
                emit(Resource.Success(data = note))
            }catch (e: IOException){//заменить

            }
        }
    }
}