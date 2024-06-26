package com.example.noteapp_cleanarchitect_mvvm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.BabyBlue
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.LightGreen
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.RedOrange
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.RedPink
import com.example.noteapp_cleanarchitect_mvvm.ui.theme.Violet
import java.time.LocalDateTime

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id :Int? =null,
    val name:String,
    val description:String,
    val date_start: LocalDateTime?,
    val date_finish:LocalDateTime?,
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