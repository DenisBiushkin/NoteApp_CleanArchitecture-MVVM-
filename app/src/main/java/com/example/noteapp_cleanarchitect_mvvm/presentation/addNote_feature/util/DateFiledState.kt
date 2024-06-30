package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.util

import java.time.LocalDateTime

data class DateFiledState(
    val date_text:String="",
    val hint:String="",
    val hintVisibility:Boolean=true,
    val dateWindowVisibility:Boolean=false,
    val dateTime: LocalDateTime = LocalDateTime.now()
)
