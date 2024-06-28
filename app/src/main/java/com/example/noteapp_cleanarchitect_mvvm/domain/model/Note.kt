package com.example.noteapp_cleanarchitect_mvvm.domain.model

import android.os.Parcelable
import androidx.media3.common.Format
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.BabyBlue
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.LightGreen
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.RedOrange
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.RedPink
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.Violet
import com.google.gson.Gson
import java.io.Serializable
import java.time.LocalDateTime

@Entity

data class Note(

    @PrimaryKey(autoGenerate = true)
    val id :Int? =null,
    val name:String,
    val description:String,
    val date_start: LocalDateTime?,
    val date_finish:LocalDateTime?,
) : Serializable {
    companion object{
        val  noteColors= listOf(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }

    fun toNoteUI():NoteUI{

        val start=date_start.let {
            date_start?.toLocalTime().toString()
        }
        val finish=date_finish.let {
            date_finish?.toLocalTime().toString()
        }
        val date=date_start.let {
            date_start?.toLocalDate().toString()
        }
        val currentDate=date_start.let {
            date_start?.toLocalDate()
        }
        return NoteUI(
            id =id,
            name=name,
            description=description,
            time_start = start,
            time_finish = finish,
            date=date,
            currentDate_noformat =currentDate
        )
    }
}