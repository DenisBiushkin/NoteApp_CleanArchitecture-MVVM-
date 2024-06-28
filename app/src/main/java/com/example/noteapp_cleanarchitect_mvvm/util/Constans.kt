package com.example.noteapp_cleanarchitect_mvvm.util

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.noteapp_cleanarchitect_mvvm.R
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import java.time.LocalDateTime

object Constans {
    const val DATABASE_NAME="notes_db"
    const val DETAIL_ARGUMENT_NOTE_ID="noteId"
    val testnote = Note(
        name = "TEST/TEST",
        description = "Улитки — тихие и неприхотливые животные, — говорили друзья, протягивая мне контейнер с животинкой. Каждую ночь теперь просыпаюсь оттого, что моё \"тихое и неприхотливое\" перетаскивает мисочку с водой на другой конец террариума и смачно бросает её в землю. Перестановку устраивает каждую ночь, чтоб её, а мне кроме моей комнаты держать её негде.",
        date_start= LocalDateTime.of(2024, 6, 26,9,0),
        date_finish = LocalDateTime.of(2024, 6, 26,10,0)
    ).toNoteUI()
    val noteError =Note(
        id=-1,
        date_start = LocalDateTime.now(),
        date_finish =LocalDateTime.now(),
        name = "Error",
        description = "Error",
    )
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