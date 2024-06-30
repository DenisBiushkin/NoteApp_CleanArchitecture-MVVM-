package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature.util

sealed class ClockSelector {

    object Time: ClockSelector()
    object Date: ClockSelector()
}