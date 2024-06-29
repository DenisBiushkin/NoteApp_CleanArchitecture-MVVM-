package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {
    private val _titleText = mutableStateOf(TextFieldState(
        hint = "Введите заголовок"
    ))
    val titleText: State<TextFieldState> =_titleText
    private val _descriptinText = mutableStateOf(TextFieldState(
        hint = "Введите описание"
    ))
    val descriptinText: State<TextFieldState> =_descriptinText

    init {

    }
    fun onEvent(event:AddNoteEvent){
        when(event){
            is AddNoteEvent.EnteredTitle ->{
                _titleText.value=titleText.value.copy(
                    text =event.title
                )
                //
            }
            is AddNoteEvent.EnteredDescription->{
                _descriptinText.value=descriptinText.value.copy(
                    text = event.description
                )
            }
            is AddNoteEvent.ChangeTitleVisibility ->{

            }
            is AddNoteEvent.ChangeDescriptionVisibility->{

            }
            is AddNoteEvent.SaveNote->{
                val intColor=Color.Cyan.toArgb()
                val newNote =Note(
                    name = _titleText.value.text,
                    description = _descriptinText.value.text,
                    date_start = LocalDateTime.now(),//изменить на поле в Viemodel
                    date_finish = LocalDateTime.now(),//изменить на поле в Viemodel
                    color=intColor
                )
                addNote(newNote)
            }

        }
    }
    private fun addNote(note: Note){
        viewModelScope.launch {
            addNoteUseCase.execute(note=note)
        }
    }
}