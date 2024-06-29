package com.example.noteapp_cleanarchitect_mvvm.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.NoteUI
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.BabyBlue
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.LightGreen
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.RedOrange
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.RedPink
import com.example.noteapp_cleanarchitect_mvvm.presentation.ui.theme.Violet
import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Entity

data class Note(

    @PrimaryKey(autoGenerate = true)
    val id :Int? =null,
    val name:String,
    val description:String,
    val date_start: LocalDateTime?,// по факту хранится как TimeStamp
    val date_finish:LocalDateTime?,
    val color:Int
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

        val formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy")
        val text = date_start!!.format(formatter)
        val russianDayOfWeek = date_start!!.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru"))
        return NoteUI(
            id =id,
            name =name,
            description =description,
            time_start = start,
            time_finish = finish,
            date =text,
            currentDate_week =russianDayOfWeek,
            color = Color(0xFFFFFFFF)
        )
    }
}