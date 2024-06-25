package com.example.noteapp_cleanarchitect_mvvm.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase:RoomDatabase() {

    abstract val noteDao:NoteDao//interface
}