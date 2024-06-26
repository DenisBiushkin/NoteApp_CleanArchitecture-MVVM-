package com.example.noteapp_cleanarchitect_mvvm.navigation

sealed class Screens(
    val route:String
) {
    object Main:Screens(route = "main_screen")
    object Detail:Screens(route = "detail_screen")
    object AddNote:Screens(route = "addnote_screen")

}