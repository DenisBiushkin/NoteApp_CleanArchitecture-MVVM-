package com.example.noteapp_cleanarchitect_mvvm.navigation

import com.example.noteapp_cleanarchitect_mvvm.util.Constans


sealed class Screens(
    val route:String
) {
    object Main:Screens(route = "main_screen")
    object Detail:Screens(
        route = "detail_screen/{${Constans.DETAIL_ARGUMENT_NOTE_ID}}"
    ){
        fun noteId(noteId:Int):String{
            return "detail_screen/${noteId}"
        }
    }
    object AddNote:Screens(route = "addnote_screen")

}