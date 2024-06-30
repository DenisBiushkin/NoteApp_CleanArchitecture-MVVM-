package com.example.noteapp_cleanarchitect_mvvm.presentation.addNote_feature

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.model.Note
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {
    private val _titleText = mutableStateOf(
        TextFieldState(hint = "Заголовок")
    )
    val titleText: State<TextFieldState> = _titleText

    private val _descriptinText = mutableStateOf(
        TextFieldState(hint = "Введите описание")
    )
    val descriptinText: State<TextFieldState> = _descriptinText

    private val _date_text= mutableStateOf(
        DateFiledState(hint = "Дата")
    )
    val date_text:State<DateFiledState> = _date_text

    private val _timeStart_text= mutableStateOf(
        DateFiledState(hint = "Время начала задачи")
    )
    val timeStart_text:State<DateFiledState> = _timeStart_text

    private val _timeFinish_text= mutableStateOf(
        DateFiledState(hint = "Время конца задачи")
    )
    val timeFinish_text:State<DateFiledState> = _timeFinish_text
    fun onEvent(event:AddNoteEvent){
        when(event){
            is AddNoteEvent.EnteredTitle ->{
                 _titleText.value=titleText.value.copy(
                     text = event.title
                 )
                //
            }
            is AddNoteEvent.ChangeTitleVisibility ->{
                    if(_titleText.value.text.isBlank())
                        _titleText.value=_titleText.value.copy(
                            hintVisibility = !event.visibility.isFocused
                        )
            }
            is AddNoteEvent.EnteredDescription->{
                _descriptinText.value=descriptinText.value.copy(
                    text = event.description
                )
            }
            is AddNoteEvent.ChangeDescriptionVisibility->{
                if(_descriptinText.value.text.isBlank())
                    _descriptinText.value=_descriptinText.value.copy(
                        hintVisibility =!event.visibility.isFocused
                    )
            }
            is AddNoteEvent.ChoiseDate->{
                SelectDateTime(
                    event=event.choiceTypeDatePicker,
                    fieldState = _date_text,
                    textFieldStateChange = {
                        _date_text.value=it.value
                    }
                )
            }
            is AddNoteEvent.ChoiseStartTime->{
                SelectDateTime(
                    event=event.choiceTypeDatePicker,
                    fieldState = _timeStart_text,
                    textFieldStateChange = {
                        _timeStart_text.value=it.value
                    },
                    selector = ClockSelector.Time
                )
            }
            is AddNoteEvent.ChoiseFinishTime->{
                SelectDateTime(
                    event=event.choiceTypeDatePicker,
                    fieldState = _timeFinish_text,
                    textFieldStateChange = {
                        _timeFinish_text.value=it.value
                    },
                    selector = ClockSelector.Time
                )
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
    private fun SelectDateTime(
        event:ChoiceTypeDatePicker,
        fieldState: MutableState<DateFiledState>,
        textFieldStateChange:(MutableState<DateFiledState>)->Unit,
        selector: ClockSelector = ClockSelector.Date
    ){
        when(event){
            is ChoiceTypeDatePicker.AcceptedDate ->{
                fieldState.value= fieldState.value.copy(
                    date_text =  when(selector){
                           is ClockSelector.Date->{
                                event.dateTime.toLocalDate().toString()
                           }
                           is ClockSelector.Time->{
                               event.dateTime.toLocalTime().toString()
                           }
                    },
                    hintVisibility = !fieldState.value.hintVisibility && date_text.value.date_text.isBlank(),
                    dateWindowVisibility =!fieldState.value.dateWindowVisibility
                )
                textFieldStateChange(fieldState)
            }
            is ChoiceTypeDatePicker.RefusedDate ->{
                fieldState.value=fieldState.value.copy(
                    dateWindowVisibility =!fieldState.value.dateWindowVisibility
                )
            }
            is ChoiceTypeDatePicker.SelectedPicker ->{
                fieldState.value=fieldState.value.copy(
                    dateWindowVisibility =!fieldState.value.dateWindowVisibility
                )
            }
        }
    }
    private fun addNote(note: Note){
        viewModelScope.launch {
            addNoteUseCase.execute(note=note)
        }
    }
}