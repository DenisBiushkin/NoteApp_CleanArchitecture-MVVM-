package com.example.noteapp_cleanarchitect_mvvm.presentation.util

import java.time.LocalDateTime

sealed class ChoiceTypeDatePicker (

){
    data class AcceptedDate(val dateTime: LocalDateTime ):ChoiceTypeDatePicker()
    object RefusedDate:ChoiceTypeDatePicker()

    object SelectedPicker:ChoiceTypeDatePicker()
}