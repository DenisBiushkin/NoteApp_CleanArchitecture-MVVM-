package com.example.noteapp_cleanarchitect_mvvm.presentation.model

import java.io.Serializable


data class NoteUI(
    val id:Int? =null,
    val name:String,
    val description:String,
    val time_start: String,
    val time_finish: String,
    val date:String,
    val currentDate_week:String="",
    val color: androidx.compose.ui.graphics.Color
): Serializable{

}
