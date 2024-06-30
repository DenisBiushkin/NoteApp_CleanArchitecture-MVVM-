package com.example.noteapp_cleanarchitect_mvvm.presentation.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

data class CurrentDay(
    val date_format:String="",
    val dayweek:String=""
){
    fun fromLocalDate(date:LocalDate):CurrentDay{
        val formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy")
        val text = date.format(formatter)
        val russianDayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru"))
        return CurrentDay(
            date_format=text,
            dayweek=russianDayOfWeek
        )
    }
}
