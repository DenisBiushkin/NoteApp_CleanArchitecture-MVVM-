package com.example.noteapp_cleanarchitect_mvvm.navigation

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.util.Constans
import com.google.gson.Gson


sealed class Screens(
    val route:String
) {
    object Main:Screens(route = "main_screen")
    object Detail:Screens(
        route = "detail_screen/{${Constans.DETAIL_ARGUMENT_NOTE_ID}}"
    ){
        fun toJsonFromNote(note:NoteUI):String{
            val gson = Gson()
            val myData = note
            val strvalue=gson.toJson(myData)
            return "detail_screen/${strvalue}"
        }
        fun toNoteFromJson(dataJson:String?): NoteUI {
            val gson = Gson()
            return gson.fromJson(dataJson, NoteUI::class.java)
        }
        fun noteId(noteId:Int):String{
            return "detail_screen/${noteId}"
        }
    }
    object AddNote:Screens(route = "addnote_screen")

}