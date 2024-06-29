package com.example.noteapp_cleanarchitect_mvvm.presentation.util

sealed class ChoiceType {
    object Accepted:ChoiceType()
    object Refused:ChoiceType()

    object Freedom:ChoiceType()
}