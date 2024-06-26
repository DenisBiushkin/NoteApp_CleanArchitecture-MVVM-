package com.example.noteapp_cleanarchitect_mvvm.util

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.noteapp_cleanarchitect_mvvm.R

object Constans {
    const val DATABASE_NAME="notes_db"
    val fontFamily= FontFamily(
        Font(R.font.lexend_thin, FontWeight.Thin) ,
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_bold, FontWeight.Bold),
        Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
        Font(R.font.lexend_extralight, FontWeight.ExtraLight),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_black, FontWeight.Black),
        Font(R.font.lexend_regular, FontWeight.Normal)
    )
}