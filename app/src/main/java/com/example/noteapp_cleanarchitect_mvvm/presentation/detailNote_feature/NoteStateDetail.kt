package com.example.noteapp_cleanarchitect_mvvm.presentation.detailNote_feature

import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import java.time.LocalDate

class NoteStateDetail (
    val note:NoteUI?=null,
    val id:Int =-1,
    val currentDay_format: CurrentDay?=null,
    val currentDay: LocalDate?=null,
    val isLoading:Boolean =false
)