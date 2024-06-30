package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import java.time.LocalDate

class NoteState (
    val notes:List<NoteUI> = emptyList(),
    val currentDay_format: CurrentDay,
    val currentDate_text:String="",
    val currentWeekDay_text: String="",
    val dateWindowVisibility:Boolean=false,
    val currentDay: LocalDate,
){
    fun copy(
        notes:List<NoteUI> = this.notes,
        currentDay_format: CurrentDay=this.currentDay_format,
        currentDate_text:String=this.currentDate_text,
        currentWeekDay_text: String=this.currentWeekDay_text,
        dateWindowVisibility:Boolean=this.dateWindowVisibility,
        currentDay: LocalDate=this.currentDay,
    ):NoteState{
        return NoteState(
            notes=notes,
            currentDay_format=currentDay_format,
            currentDate_text=currentDate_text,
            currentWeekDay_text=currentWeekDay_text,
            dateWindowVisibility=dateWindowVisibility,
            currentDay=currentDay
        )
    }
}