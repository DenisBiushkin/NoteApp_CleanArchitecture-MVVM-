package com.example.noteapp_cleanarchitect_mvvm.presentation.model

import java.time.LocalDateTime

import android.os.Parcelable
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.NoteState
import java.io.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


data class NoteUI(
    val id :Int? =null,
    val name:String,
    val description:String,
    val time_start: String,
    val time_finish: String,
    val date:String,
    val currentDate_noformat:LocalDate?
): Serializable{
    fun currentDay(): CurrentDay{

        val formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy")
        val text = date.format(formatter)
        val russianDayOfWeek = currentDate_noformat!!.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru"))

        return CurrentDay(
            date_format = text,
            dayweek = russianDayOfWeek
        )

    }
}
