package com.example.noteapp_cleanarchitect_mvvm.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime

@Dao
interface NoteDao {

    @Query("""
        SELECT * FROM note 
            WHERE (date_start BETWEEN :date AND :date+86400)
            AND (date_finish BETWEEN :date AND :date+86400)
    """)//мб доработать потом для поиска по временному промежутку
    fun getNotesByDate(date: LocalDateTime):Flow<List<Note>>

    @Query("  SELECT * FROM note WHERE id=:noteId")
    suspend fun getNoteById(noteId:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)
}