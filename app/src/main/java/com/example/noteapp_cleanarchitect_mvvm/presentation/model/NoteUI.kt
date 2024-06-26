package com.example.noteapp_cleanarchitect_mvvm.presentation.model

import java.time.LocalDateTime

data class NoteUI(
    val id :Int? =null,
    val name:String,
    val description:String,
    val time_start: String,
    val time_finish: String,
    val date:String
)
