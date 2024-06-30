package com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.AddNoteUseCase
import com.example.noteapp_cleanarchitect_mvvm.domain.use_case.GetNotesByDateUseCase
import com.example.noteapp_cleanarchitect_mvvm.presentation.model.CurrentDay
import com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util.NoteMainEvent
import com.example.noteapp_cleanarchitect_mvvm.presentation.toDoNote_feature.util.NoteState
import com.example.noteapp_cleanarchitect_mvvm.presentation.util.ChoiceTypeDatePicker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getNotesByDateUseCase: GetNotesByDateUseCase,
    private val addNoteUseCase: AddNoteUseCase
):ViewModel() {

    private var _state= MutableStateFlow(
        NoteState(
        currentDay = LocalDate.now(),
        currentDay_format = CurrentDay().fromLocalDate(LocalDate.now())
        )
    )
    val state= _state.asStateFlow()
    init {
        GetNotesByDate(state.value.currentDay.atTime(0,0))
    }
    fun onEvent(event: NoteMainEvent){
        when(event){
            is NoteMainEvent.DeleteNote ->{
               //удалить строку дела
            }
            is NoteMainEvent.ChangeDatePickerState->{
                when(event.choiceTypeDatePicker){
                    is ChoiceTypeDatePicker.SelectedPicker->{
                        println("Выбор даты")
                        _state.value=state.value.copy(
                            dateWindowVisibility = !state.value.dateWindowVisibility
                        )
                    }
                    is ChoiceTypeDatePicker.RefusedDate->{
                        _state.value=state.value.copy(
                            dateWindowVisibility = !state.value.dateWindowVisibility
                        )
                    }
                    is ChoiceTypeDatePicker.AcceptedDate ->{
                        val currentDay = event.choiceTypeDatePicker.dateTime.toLocalDate()
                        _state.value=state.value.copy(
                            dateWindowVisibility = !state.value.dateWindowVisibility,
                            currentDay = currentDay,
                            currentDay_format = CurrentDay().fromLocalDate(currentDay)
                        )
                        GetNotesByDate(event.choiceTypeDatePicker.dateTime)
                    }
                }
            }
        }
    }
    private fun GetNotesByDate(date_search: LocalDateTime){
        viewModelScope.launch {
            getNotesByDateUseCase.execute(date_search).collect{
                notes->
                val NotesUI=notes.map { it.toNoteUI() }
                _state.value= state.value.copy(
                    notes=NotesUI
                )
            }
        }
    }
}


