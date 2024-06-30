package com.example.noteapp_cleanarchitect_mvvm.domain.use_case

import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.model.NoteValidator
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ValidateNewNoteUseCase(
){
    fun execute(
        timeStart:String,
        timeFinish:String,
        date:String,
       title:String,
        description: String,
        color:Int
    ) :NoteValidator{
        if(
            timeStart.isBlank() || timeFinish.isBlank() ||
            title.isBlank() || description.isBlank()
        ){
            return NoteValidator.Error("Все поля должны быть заполныен")
        }
        if(
            timeStart==timeFinish
        )
            return NoteValidator.Error("")

        val dateTimeStartString="${date} ${timeStart}"
        val dateTimeFinishString="${date} ${timeFinish}"

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        println(dateTimeStartString)
        println(LocalDateTime.parse(dateTimeStartString, formatter))
        val note= Note(
            name = title,
            description = description,
            date_start = LocalDateTime.parse(dateTimeStartString, formatter),
            date_finish =LocalDateTime.parse(dateTimeFinishString, formatter),
            color=color
        )
        return NoteValidator.CorrectNote(note = note)
    }
}