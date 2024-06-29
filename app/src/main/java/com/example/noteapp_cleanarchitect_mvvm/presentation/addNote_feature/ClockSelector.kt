package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature

sealed class ClockSelector {

    object Time:ClockSelector()
    object Date:ClockSelector()
}