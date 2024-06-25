package com.example.noteapp_cleanarchitect_mvvm.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp_cleanarchitect_mvvm.data.data_source.NoteDatabase
import com.example.noteapp_cleanarchitect_mvvm.data.repository.NoteRepositoryImpl
import com.example.noteapp_cleanarchitect_mvvm.domain.repository.NoteRepository
import com.example.noteapp_cleanarchitect_mvvm.util.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule   {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application):NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            Constans.DATABASE_NAME
        ).build()
    }
    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

}