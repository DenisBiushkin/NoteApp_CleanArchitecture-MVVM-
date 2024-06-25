package com.example.noteapp_cleanarchitect_mvvm.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import kotlinx.coroutines.flow.Flow
import java.time.Instant

@Dao
interface NoteDao {

    @Query("SELECT * FROM note ")
    suspend fun getNotesByDate():List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)
}