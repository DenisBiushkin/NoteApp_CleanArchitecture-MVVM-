package com.example.noteapp_cleanarchitect_mvvm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.BabyBlue
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.LightGreen
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.RedOrange
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.RedPink
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.Violet

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id :Int? =null,
    val name:String,
    val description:String,
){
    companion object{
        val  noteColors= listOf(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }
}